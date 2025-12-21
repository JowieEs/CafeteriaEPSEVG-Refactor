package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;
import com.github.jowiees.CafeteriaEPSEVG.exception.ItemNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.mapper.item.ItemMapper;
import com.github.jowiees.CafeteriaEPSEVG.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ItemResponse> getAll(Pageable pageable) {
        return itemRepository.findAll(enforcePageLimits(pageable))
                .map(itemMapper::toSummaryResponse);
    }

    public ItemResponse getById(Long id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDetailResponse)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }
}
