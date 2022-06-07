package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.PiecesArchive;
import com.sfeproject.employesystem.repository.PiecesArchiveRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/piecesarchive")
@CrossOrigin
public class PiecesArchiveController {

    private final PiecesArchiveRepository piecesArchiveRepository;

    public PiecesArchiveController(PiecesArchiveRepository piecesArchiveRepository) {
        this.piecesArchiveRepository = piecesArchiveRepository;
    }

    @GetMapping("/getall")
    public List<PiecesArchive> archive() {
        return piecesArchiveRepository.findAll();
    }
}
