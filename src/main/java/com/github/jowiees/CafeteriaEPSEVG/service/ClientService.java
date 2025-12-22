package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.dto.request.client.ClientFilter;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.mapper.client.ClientMapper;
import com.github.jowiees.CafeteriaEPSEVG.repository.ClientRepository;
import com.github.jowiees.CafeteriaEPSEVG.exception.ClientNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.specification.ClientSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.jowiees.CafeteriaEPSEVG.service.utils.LimitedPageable.enforcePageLimits;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @SuppressWarnings("NullableProblems")
    public Page<ClientSummaryResponse> getAll(ClientFilter clientFilter, Pageable pageable){
        Pageable safePageable = enforcePageLimits(pageable);
        Specification<Client> specification = ClientSpecification.withFilter(clientFilter);
        return clientRepository.findAll(specification, safePageable).map(clientMapper::toSummaryResponse);
    }

    public ClientDetailResponse getById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDetailResponse)
                .orElseThrow(
                        () -> new ClientNotFoundException(id)
                );
    }
}
