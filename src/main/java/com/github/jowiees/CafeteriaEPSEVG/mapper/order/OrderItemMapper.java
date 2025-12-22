package com.github.jowiees.CafeteriaEPSEVG.mapper.order;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.order.OrderItemDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.order.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class OrderItemMapper {

    public OrderItemDetailResponse toDetailResponse(OrderItem orderItem) {
        return new OrderItemDetailResponse(
                orderItem.getItem().getId(),
                orderItem.getItem().getItemType(),
                orderItem.getItem().getName(),
                orderItem.getQuantity(),
                orderItem.getSellingPrice(),
                orderItem.getSellingPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()))
        );
    }
}
