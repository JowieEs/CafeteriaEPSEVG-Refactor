package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.response.client.ClientResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.ProfessorResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.client.StudentResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.ClientService;
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
    public List<ClientResponse> getAllClients() {
        return clientService.getAll();
    }

    @GetMapping("students")
    public List<StudentResponse> getAllStudents() {
        return clientService.getAllStudents();
    }

    @GetMapping("professors")
    public List<ProfessorResponse> getAllProfessors() {
        return clientService.getAllProfessors();
    }

    @GetMapping("{memberID}")
    public ClientResponse getClientById(@PathVariable Integer memberID) {
        return clientService.getById(memberID);
    }
}
