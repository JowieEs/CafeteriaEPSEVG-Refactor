package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.dto.request.item.ItemFilter;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import com.github.jowiees.CafeteriaEPSEVG.exception.ItemNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.mapper.item.ItemMapper;
import com.github.jowiees.CafeteriaEPSEVG.repository.ItemRepository;
import com.github.jowiees.CafeteriaEPSEVG.specification.ClientSpecification;
import com.github.jowiees.CafeteriaEPSEVG.specification.ItemSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.jowiees.CafeteriaEPSEVG.service.utils.LimitedPageable.enforcePageLimits;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @SuppressWarnings("NullableProblems")
    public Page<ItemResponse> getAll(ItemFilter filter, Pageable pageable) {
        Pageable safePageable = enforcePageLimits(pageable);
        Specification<Item> specification = ItemSpecification.withFilter(filter);
        return itemRepository.findAll(specification, safePageable)
                .map(itemMapper::toSummaryResponse);
    }

    public ItemResponse getById(Long id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDetailResponse)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }
}
