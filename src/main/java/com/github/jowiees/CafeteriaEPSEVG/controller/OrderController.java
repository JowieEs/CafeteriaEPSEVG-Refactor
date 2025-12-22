package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @SuppressWarnings("NullableProblems")
    @GetMapping
    public Page<OrderSummaryResponse> getAll(Pageable pageable) {
        return orderService.getAll(pageable);
    }

    @GetMapping("{id}")
    public OrderDetailResponse getById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
