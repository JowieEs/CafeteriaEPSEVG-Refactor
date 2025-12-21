package com.github.jowiees.CafeteriaEPSEVG.mapper;

import com.github.jowiees.CafeteriaEPSEVG.entity.order.Order;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderItemDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.mapper.item.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ItemMapper itemMapper;
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

        List<OrderItemDetailResponse> itemResponses = order.getOrderItems().stream()
                .map(orderItem -> new OrderItemDetailResponse(
                        orderItem.getQuantity(),
                        itemMapper.toSummaryResponse(orderItem.getItem()),
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
