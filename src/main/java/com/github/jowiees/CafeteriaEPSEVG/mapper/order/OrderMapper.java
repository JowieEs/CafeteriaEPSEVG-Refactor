package com.github.jowiees.CafeteriaEPSEVG.mapper.order;

import com.github.jowiees.CafeteriaEPSEVG.entity.order.Order;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderItemDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.mapper.client.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderItemMapper orderItemMapper;
    private final ClientMapper clientMapper;

    public OrderSummaryResponse toSummaryResponse(Order order) {
        ClientSummaryResponse clientSummaryResponse = null;
        if (order.getClient() != null) {
            clientSummaryResponse = clientMapper.toSummaryResponse(order.getClient());
        }

        return new OrderSummaryResponse(
                order.getId(),
                order.getTotalPrice(),
                order.getCreatedAt(),
                clientSummaryResponse
        );
    }

    public OrderDetailResponse toDetailResponse(Order order) {
        ClientSummaryResponse clientSummaryResponse = null;
        if (order.getClient() != null) {
            clientSummaryResponse = clientMapper.toSummaryResponse(order.getClient());
        }

        List<OrderItemDetailResponse> orderItemDetailResponses = order.getOrderItems()
                .stream()
                .map(orderItemMapper::toDetailResponse)
                .toList();

        return new OrderDetailResponse(
                order.getId(),
                order.getTotalPrice(),
                order.getPaymentMethod(),
                order.getCreatedAt(),
                clientSummaryResponse,
                orderItemDetailResponses
        );
    }
}
