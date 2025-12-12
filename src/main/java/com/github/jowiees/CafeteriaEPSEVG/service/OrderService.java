package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.exception.OrderNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.repository.OrderRepository;
import com.github.jowiees.CafeteriaEPSEVG.response.QuantityItemResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> getAll() {
        return orderRepository.findAll().stream().map(
                order -> new OrderResponse(
                        order.getId(),
                        order.getDateTime(),
                        order.getTotalPrice(),
                        order.getPaymentMethod(),
                        (order.getClient() != null) ? order.getClient().getMemberId() : null
                )
        ).toList();
    }

    public OrderDetailResponse getById(Long orderId) {
        return orderRepository.findById(orderId).map(
                order -> new OrderDetailResponse(
                        order.getId(),
                        order.getDateTime(),
                        order.getTotalPrice(),
                        order.getPaymentMethod(),
                        (order.getClient() != null) ? order.getClient().getMemberId() : null,
                        order.getQuantityItems().stream().map(
                                quantityItem -> new QuantityItemResponse(
                                        (quantityItem.getItem() != null) ? quantityItem.getItem().getId() : null,
                                        (quantityItem.getItem() != null) ? quantityItem.getQuantity() : null,
                                        (quantityItem.getItem() != null) ? quantityItem.getItem().getItemType() : null
                                )
                        ).toList()
                )
        ).orElseThrow(
                () -> new OrderNotFoundException(orderId)
        );
    }
}
