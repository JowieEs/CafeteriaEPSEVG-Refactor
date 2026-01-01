package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.unit.UnitDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.unit.UnitSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("units")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @SuppressWarnings("NullableProblems")
    @GetMapping
    public Page<UnitSummaryResponse> findAll(Pageable pageable) {
        return unitService.findAll(pageable);
    }

    @GetMapping("{id}")
    public UnitDetailResponse findById(@PathVariable Long id) {
        return unitService.findById(id);
    }
}
