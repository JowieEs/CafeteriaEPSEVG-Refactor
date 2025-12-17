package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.repository.ClientRepository;
import com.github.jowiees.CafeteriaEPSEVG.exception.ClientNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientBaseResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.StudentResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.utils.MapClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.github.jowiees.CafeteriaEPSEVG.service.utils.LimitedPageable.enforcePageLimits;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @SuppressWarnings("NullableProblems")
    public Page<ClientSummaryResponse> getAll(Pageable pageable){
        Pageable safePageable = enforcePageLimits(pageable);
        return clientRepository.findAll(safePageable).map(
                client -> new ClientSummaryResponse(
                       client.getId(),
                       client.getName(),
                       client.getClientType()
                )
        );
    }

    public ClientBaseResponse getById(Long id) {
        return clientRepository.findById(id)
                .map(MapClientDTO::mapToDto)
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
