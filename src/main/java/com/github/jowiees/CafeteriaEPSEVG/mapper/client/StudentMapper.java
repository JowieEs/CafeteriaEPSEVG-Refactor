package com.github.jowiees.CafeteriaEPSEVG.mapper.client;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.StudentResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentResponse toResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .universityCardCode(student.getUniversityCardCode())
                .name(student.getName())
                .clientType(student.getClientType())
                .createdAt(student.getCreatedAt())
                .degree(student.getDegree())
                .build();
    }
}
