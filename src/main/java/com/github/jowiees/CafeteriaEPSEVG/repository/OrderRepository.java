package com.github.jowiees.CafeteriaEPSEVG.repository;

import com.github.jowiees.CafeteriaEPSEVG.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {

    @SuppressWarnings("NullableProblems")
    @Override
    @EntityGraph(attributePaths = {"client"})
    Page<Order> findAll(Pageable pageable);

    @Query("""
            SELECT o FROM Order o
            LEFT JOIN FETCH o.orderItems oi
            LEFT JOIN FETCH oi.item i
            WHERE o.id = :id
            """)
    Optional<Order> findByIdWithItems(@Param("id") Long id);
}
