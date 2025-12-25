package com.github.jowiees.CafeteriaEPSEVG.repository;

import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.menu.Menu;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    @Query("SELECT m from Menu m")
    List<Menu> findAllMenus();

    @Query("SELECT p from Product p")
    List<Product> findAllProducts();
}
