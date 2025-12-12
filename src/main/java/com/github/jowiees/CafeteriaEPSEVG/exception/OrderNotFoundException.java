package com.github.jowiees.CafeteriaEPSEVG.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super("Could not find order with order_id = " + orderId);
    }
}
