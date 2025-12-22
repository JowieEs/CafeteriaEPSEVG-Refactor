package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.entity.order.Order;
import com.github.jowiees.CafeteriaEPSEVG.exception.OrderNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.mapper.order.OrderMapper;
import com.github.jowiees.CafeteriaEPSEVG.repository.OrderRepository;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderSummaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.jowiees.CafeteriaEPSEVG.service.utils.LimitedPageable.enforcePageLimits;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @SuppressWarnings("NullableProblems")
    public Page<OrderSummaryResponse> getAll(Pageable pageable) {
        return orderRepository.findAll(enforcePageLimits(pageable)).map(orderMapper::toSummaryResponse);
    }

    public OrderDetailResponse getById(Long orderId) {
        Order order = orderRepository.findByIdWithItems(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        return orderMapper.toDetailResponse(order);
    }

}
