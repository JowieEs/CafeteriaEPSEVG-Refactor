package com.github.jowiees.CafeteriaEPSEVG.repository;

import com.github.jowiees.CafeteriaEPSEVG.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
