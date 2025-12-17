package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.exception.OrderNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.repository.OrderRepository;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.github.jowiees.CafeteriaEPSEVG.service.utils.LimitedPageable.enforcePageLimits;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @SuppressWarnings("NullableProblems")
    public Page<OrderResponse> getAll(Pageable pageable) {
        return orderRepository.findAll(enforcePageLimits(pageable)).map(
                order -> new OrderResponse(
                        order.getId(),
                        (order.getClient() != null) ? order.getClient().getId() : null,
                        order.getTotalPrice(),
                        order.getPaymentMethod(),
                        order.getCreatedAt()

                )
        );
    }


    public OrderDetailResponse getById(Long orderId) {
        return orderRepository.findById(orderId).map(
                order -> new OrderDetailResponse(
                        order.getId(),
                        order.getTotalPrice(),
                        order.getPaymentMethod(),
                        order.getCreatedAt(),
                        (order.getClient() != null) ? new ClientSummaryResponse(
                                order.getClient().getId(),
                                order.getClient().getName(),
                                order.getClient().getClientType()
                        ) : null
                )
        ).orElseThrow(
                () -> new OrderNotFoundException(orderId)
        );
    }
}
