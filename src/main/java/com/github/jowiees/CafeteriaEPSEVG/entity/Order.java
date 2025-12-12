package com.github.jowiees.CafeteriaEPSEVG.entity;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import com.github.jowiees.CafeteriaEPSEVG.entity.quantityitem.QuantityItem;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "comanda")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime dateTime;
    private Double totalPrice;
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = true)
    private Client client;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<QuantityItem> quantityItems;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Client getClient() {
        return client;
    }

    public List<QuantityItem> getQuantityItems() {
        return quantityItems;
    }
}
