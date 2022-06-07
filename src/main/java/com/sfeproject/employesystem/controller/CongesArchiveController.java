package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.CongesArchive;
import com.sfeproject.employesystem.model.Employe;
import com.sfeproject.employesystem.repository.CongesArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/congesarchive")
@CrossOrigin
public class CongesArchiveController {

    @Autowired
    private final CongesArchiveRepository congesArchiveRepository;

    public CongesArchiveController(CongesArchiveRepository congesArchiveRepository) {
        this.congesArchiveRepository = congesArchiveRepository;
    }

    @GetMapping("/getall")
    public List<CongesArchive> archive() {
        return congesArchiveRepository.findAll();
    }

    @GetMapping("/getemp/{id}")
    public Employe getEmp(@PathVariable int id) {
        return congesArchiveRepository.getEmployeOfTheArchivedConge(id);
    }
}
