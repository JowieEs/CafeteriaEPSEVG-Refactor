package com.github.jowiees.CafeteriaEPSEVG.service.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class LimitedPageable {

    public static PageRequest enforcePageLimits(Pageable pageable) {
        int pageLimit = 100;
        return PageRequest.of(
                pageable.getPageNumber(),
                Math.min(pageLimit, pageable.getPageSize()),
                pageable.getSort()
        );
    }
}
