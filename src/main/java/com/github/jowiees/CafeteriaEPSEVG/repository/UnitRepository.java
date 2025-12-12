package com.github.jowiees.CafeteriaEPSEVG.repository;

import com.github.jowiees.CafeteriaEPSEVG.entity.unit.Unit;
import com.github.jowiees.CafeteriaEPSEVG.entity.unit.UnitKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, UnitKey> {
}
