package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.unit.UnitDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.unit.UnitSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.exception.UnitNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.mapper.unit.UnitMapper;
import com.github.jowiees.CafeteriaEPSEVG.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.jowiees.CafeteriaEPSEVG.service.utils.LimitedPageable.enforcePageLimits;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;

    @SuppressWarnings("NullableProblems")
    public Page<UnitSummaryResponse> findAll(Pageable pageable) {
        Pageable safePageable = enforcePageLimits(pageable);

        return unitRepository.findAll(safePageable).map(unitMapper::toSummaryResponse);
    }

    public UnitDetailResponse findById(Long id) {
        return unitRepository.findById(id).map(unitMapper::toDetailResponse).orElseThrow(
                () -> new UnitNotFoundException(id)
        );
    }
}
