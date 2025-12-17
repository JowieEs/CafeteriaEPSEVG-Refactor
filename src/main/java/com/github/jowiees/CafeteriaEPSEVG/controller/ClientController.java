package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientBaseResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.StudentResponse;
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
    public Page<ClientSummaryResponse> getAll(Pageable pageable) {
        return clientService.getAll(pageable);
    }

    @SuppressWarnings("NullableProblems")
    @GetMapping("students")
    public Page<StudentResponse> getAllStudents(Pageable pageable) {
        return clientService.getAllStudents(pageable);
    }

    @SuppressWarnings("NullableProblems")
    @GetMapping("professors")
    public Page<ProfessorResponse> getAllProfessors(Pageable pageable) {
        return clientService.getAllProfessors(pageable);
    }

    @GetMapping("{id}")
    public ClientBaseResponse getById(@PathVariable Long id) {
        return clientService.getById(id);
    }
}
