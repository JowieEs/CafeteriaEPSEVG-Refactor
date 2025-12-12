package com.github.jowiees.CafeteriaEPSEVG.entity.quantityitem;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuantityItemKey implements Serializable {

    @Column(name = "comanda_id")
    private Long orderId;

    @Column(name = "item_id")
    private Long itemId;

    public Long getOrderId() {
        return orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuantityItemKey that = (QuantityItemKey) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId);
    }
}
