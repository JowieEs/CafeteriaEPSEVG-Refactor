package com.github.jowiees.CafeteriaEPSEVG.entity.quantityitem;

import com.github.jowiees.CafeteriaEPSEVG.entity.Order;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import jakarta.persistence.*;

@Entity
@Table(name = "quantitat_items")
public class QuantityItem {

    @EmbeddedId
    private QuantityItemKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "comanda_id")
    private Order order;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer quantity;

    public QuantityItemKey getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
