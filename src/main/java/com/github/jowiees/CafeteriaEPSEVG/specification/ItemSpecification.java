package com.github.jowiees.CafeteriaEPSEVG.specification;

import com.github.jowiees.CafeteriaEPSEVG.dto.request.item.ItemFilter;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemSpecification {

    public static Specification<Item> withFilter(ItemFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getItemType() != null && !filter.getItemType().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("itemType"),
                        filter.getItemType()
                ));
            }

            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + filter.getName().toLowerCase() + "%"
                ));
            }

            if (filter.getMaxPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("sellingPrice"),
                        filter.getMaxPrice()
                ));
            }

            if (filter.getMinPrice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("sellingPrice"),
                        filter.getMinPrice().max(BigDecimal.ZERO)
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
