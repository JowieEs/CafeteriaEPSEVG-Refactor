package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.StudentResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public Page<ClientResponse> getAllClients(Pageable pageable) {
        return clientService.getAll(pageable);
    }

    @GetMapping("students")
    public Page<StudentResponse> getAllStudents(Pageable pageable) {
        return clientService.getAllStudents(pageable);
    }

    @GetMapping("professors")
    public Page<ProfessorResponse> getAllProfessors(Pageable pageable) {
        return clientService.getAllProfessors(pageable);
    }

    @GetMapping("{id}")
    public ClientResponse getClientById(@PathVariable Long id) {
        return clientService.getById(id);
    }
}
