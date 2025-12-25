package com.github.jowiees.CafeteriaEPSEVG.mapper.unit;

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
}
