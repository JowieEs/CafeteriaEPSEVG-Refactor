package com.github.jowiees.CafeteriaEPSEVG.repository;

import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Menu;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT m from Menu m")
    List<Menu> findAllMenus();

    @Query("SELECT p from Product p")
    List<Product> findAllProducts();
}
