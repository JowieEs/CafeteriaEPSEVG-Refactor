package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.entity.Order;
import com.github.jowiees.CafeteriaEPSEVG.exception.OrderNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.repository.OrderRepository;
import com.github.jowiees.CafeteriaEPSEVG.response.OrderItemResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.order.OrderSummaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static com.github.jowiees.CafeteriaEPSEVG.service.utils.LimitedPageable.enforcePageLimits;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @SuppressWarnings("NullableProblems")
    public Page<OrderSummaryResponse> getAll(Pageable pageable) {
        return orderRepository.findAll(enforcePageLimits(pageable)).map(
                order -> new OrderSummaryResponse(
                        order.getId(),
                        (order.getClient() != null) ? order.getClient().getName() : null,
                        order.getTotalPrice(),
                        order.getCreatedAt()

                )
        );
    }


    public OrderDetailResponse getById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new OrderNotFoundException(orderId)
        );

        ClientSummaryResponse clientSummaryResponse = null;
        if (order.getClient() != null) {
            clientSummaryResponse = new ClientSummaryResponse(
                    order.getClient().getId(),
                    order.getClient().getName(),
                    order.getClient().getClientType()
            );
        }

        List<OrderItemResponse> itemResponses = order.getOrderItems().stream()
                .map(orderItem -> new OrderItemResponse(
                        orderItem.getItem().getId(),
                        orderItem.getItem().getName(),
                        orderItem.getQuantity(),
                        orderItem.getItem().getSellingPrice(),
                        orderItem.getItem().getSellingPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()))
                )).toList();

        return new OrderDetailResponse(
                order.getId(),
                order.getTotalPrice(),
                order.getPaymentMethod(),
                order.getCreatedAt(),
                clientSummaryResponse,
                itemResponses
        );
    }

}
