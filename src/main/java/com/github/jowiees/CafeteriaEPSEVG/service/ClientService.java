package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.repository.ClientRepository;
import com.github.jowiees.CafeteriaEPSEVG.exception.ClientNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientBaseResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.StudentResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.utils.MapClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.jowiees.CafeteriaEPSEVG.service.utils.LimitedPageable.enforcePageLimits;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepository;

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
                        s.getClientType(),
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
                    p.getClientType(),
                    p.getCreatedAt(),
                    p.getDepartment()
            )
        );
    }


}
