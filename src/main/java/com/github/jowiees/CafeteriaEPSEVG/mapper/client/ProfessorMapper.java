package com.github.jowiees.CafeteriaEPSEVG.mapper.client;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public ProfessorResponse toResponse(Professor professor) {
        return ProfessorResponse.builder()
                .id(professor.getId())
                .universityCardCode(professor.getUniversityCardCode())
                .name(professor.getName())
                .clientType(professor.getClientType())
                .createdAt(professor.getCreatedAt())
                .department(professor.getDepartment())
                .build();
    }
}
