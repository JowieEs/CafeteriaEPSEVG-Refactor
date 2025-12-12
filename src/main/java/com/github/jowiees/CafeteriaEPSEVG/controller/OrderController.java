package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{orderId}")
    public OrderDetailResponse getById(@PathVariable Long orderId) {
        return orderService.getById(orderId);
    }
}
