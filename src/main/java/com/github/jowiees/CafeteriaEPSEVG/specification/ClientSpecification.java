package com.github.jowiees.CafeteriaEPSEVG.specification;

import com.github.jowiees.CafeteriaEPSEVG.dto.request.client.ClientFilter;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ClientSpecification {

    public static Specification<Client> withFilter(ClientFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getClientType() != null && !filter.getClientType().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("clientType"),filter.getClientType()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
