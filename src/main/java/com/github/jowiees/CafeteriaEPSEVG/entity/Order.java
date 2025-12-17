package com.github.jowiees.CafeteriaEPSEVG.entity;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false, length = 20)
    private String paymentMethod;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order")
    Set<OrderItem> orderItems;


    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
}