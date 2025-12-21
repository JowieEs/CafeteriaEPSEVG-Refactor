package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.dto.request.client.ClientFilter;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @SuppressWarnings("NullableProblems")
    @GetMapping
    public Page<ClientSummaryResponse> getAll(@ModelAttribute ClientFilter clientFilter, Pageable pageable) {
        return clientService.getAll(clientFilter, pageable);
    }

    @GetMapping("{id}")
    public ClientDetailResponse getById(@PathVariable Long id) {
        return clientService.getById(id);
    }
}
