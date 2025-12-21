package com.github.jowiees.CafeteriaEPSEVG.mapper;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Professor;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Student;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientSummaryResponse toSummaryResponse (Client client) {
        return new ClientSummaryResponse(
                client.getId(),
                client.getName(),
                client.getClientType()
        );
    }

    public ClientDetailResponse toDetailResponse(Client client) {
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
