package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Student;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Professor;
import com.github.jowiees.CafeteriaEPSEVG.repository.ClientRepository;
import com.github.jowiees.CafeteriaEPSEVG.exception.ClientNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.StudentResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ProfessorResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    private ClientResponse mapToDto(Client client) {
        return switch (client) {
            case Professor p -> new ProfessorResponse(
                    p.getId(),
                    p.getUniversityCardCode(),
                    p.getName(),
                    "Professor",
                    p.getCreatedAt(),
                    p.getDepartment()
            );

            case Student s -> new StudentResponse(
                    s.getId(),
                    s.getUniversityCardCode(),
                    s.getName(),
                    "Student",
                    s.getCreatedAt(),
                    s.getDegree()
            );
            default -> throw new IllegalStateException("Unexpected value: " + client);
        };
    }

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private PageRequest enforcePageLimits(Pageable pageable) {
        int pageLimit = 100;
        return PageRequest.of(
                pageable.getPageNumber(),
                Math.min(pageLimit, pageable.getPageSize()),
                pageable.getSort()
        );
    }

    @SuppressWarnings("NullableProblems")
    public Page<ClientResponse> getAll(Pageable pageable){
        Pageable safePageable = enforcePageLimits(pageable);
        return clientRepository.findAll(safePageable).map(this::mapToDto);
    }

    public ClientResponse getById(Long id) {
        return clientRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(
                        () -> new ClientNotFoundException(id)
                );
    }

    @SuppressWarnings("NullableProblems")
    public Page<StudentResponse> getAllStudents(Pageable pageable) {
        Pageable safePageable = enforcePageLimits(pageable);
        return clientRepository.findAllStudents(safePageable).map(
                s -> new StudentResponse(
                        s.getId(),
                        s.getUniversityCardCode(),
                        s.getName(),
                        "Student",
                        s.getCreatedAt(),
                        s.getDegree()
                )
        );
    }

    @SuppressWarnings("NullableProblems")
    public Page<ProfessorResponse> getAllProfessors(Pageable pageable) {
        Pageable safePageable = enforcePageLimits(pageable);
        return clientRepository.findAllProfessors(safePageable).map(
                p -> new ProfessorResponse(
                    p.getId(),
                    p.getUniversityCardCode(),
                    p.getName(),
                    "Professor",
                    p.getCreatedAt(),
                    p.getDepartment()
            )
        );
    }


}
