package com.github.jowiees.CafeteriaEPSEVG.mapper.client;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Professor;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Student;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMapper {

    private final ProfessorMapper professorMapper;
    private final StudentMapper studentMapper;

    public ClientSummaryResponse toSummaryResponse (Client client) {
        return new ClientSummaryResponse(
                client.getId(),
                client.getName(),
                client.getClientType()
        );
    }

    public ClientDetailResponse toDetailResponse(Client client) {
        return switch (client) {
            case Professor p -> professorMapper.toResponse(p);

            case Student s -> studentMapper.toResponse(s);

            default -> throw new IllegalStateException("Unexpected value: " + client);
        };
    }
}
