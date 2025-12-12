package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Student;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Professor;
import com.github.jowiees.CafeteriaEPSEVG.repository.ClientRepository;
import com.github.jowiees.CafeteriaEPSEVG.exception.ClientNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.StudentResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ProfessorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    private ClientResponse mapToDto(Client client) {
        return switch (client) {
            case Professor prof -> new ProfessorResponse(
                    prof.getMemberId(),
                    "Professorat",
                    prof.getEmail()
            );

            case Student est -> new StudentResponse(
                    est.getMemberId(),
                    "Estudiant"
            );
            default -> throw new IllegalStateException("Unexpected value: " + client);
        };
    }

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientResponse> getAll(){
        return clientRepository.findAll().stream().map(this::mapToDto).toList();
    }

    public ClientResponse getById(Integer memberID) {
        return clientRepository.findById(memberID)
                .map(this::mapToDto)
                .orElseThrow(
                        () -> new ClientNotFoundException(memberID)
                );
    }

    public List<StudentResponse> getAllStudents() {
        return clientRepository.findAllStudents().stream().map(
                s -> new StudentResponse(
                    s.getMemberId(),
                    "Estudiant"
                )
        ).toList();
    }

    public List<ProfessorResponse> getAllProfessors() {
        return clientRepository.findAllProfessors().stream().map(
                p -> new ProfessorResponse(
                        p.getMemberId(),
                        "Professorat",
                        p.getEmail()
                )
        ).toList();
    }


}
