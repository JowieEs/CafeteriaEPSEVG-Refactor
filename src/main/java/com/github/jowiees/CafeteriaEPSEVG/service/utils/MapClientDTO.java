package com.github.jowiees.CafeteriaEPSEVG.service.utils;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Professor;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Student;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientBaseResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.StudentResponse;
import org.hibernate.Hibernate;

public class MapClientDTO {

    public static ClientBaseResponse mapToDto(Client client) {
        return switch (client) {
            case Professor p -> new ProfessorResponse(
                    p.getId(),
                    p.getUniversityCardCode(),
                    p.getName(),
                    p.getClientType(),
                    p.getCreatedAt(),
                    p.getDepartment()
            );

            case Student s -> new StudentResponse(
                    s.getId(),
                    s.getUniversityCardCode(),
                    s.getName(),
                    s.getClientType(),
                    s.getCreatedAt(),
                    s.getDegree()
            );
            default -> throw new IllegalStateException("Unexpected value: " + client);
        };
    }
}
