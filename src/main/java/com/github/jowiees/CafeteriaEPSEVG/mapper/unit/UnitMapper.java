package com.github.jowiees.CafeteriaEPSEVG.mapper.unit;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.unit.UnitDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.unit.UnitSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper {
    public UnitSummaryResponse toSummaryResponse(Unit unit) {
        return new UnitSummaryResponse(
                unit.getId(),
                unit.getName(),
                unit.getStock()
        );
    }

    public UnitDetailResponse toDetailResponse(Unit unit) {
        return new UnitDetailResponse(
                unit.getId(),
                unit.getName(),
                unit.getDescription(),
                unit.getBarcode(),
                unit.getStock()
        );
    }
}
