package com.sfeproject.employesystem.controller;


import com.sfeproject.employesystem.model.DemandePiece;

import com.sfeproject.employesystem.repository.DemandePieceRepository;
import com.sfeproject.employesystem.service.DemandePieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandespiece")
@CrossOrigin
public class DemandePieceController {

    @Autowired
    private DemandePieceService demandePieceService;
    @Autowired
    private DemandePieceRepository demandePieceRepository;

    @GetMapping("/get/{id}")
    public DemandePiece getDemandePiece(@PathVariable int id){
        return demandePieceService.getDemangePiece(id);
    }

    @GetMapping("/gettypepiece/{id}")
    public String getTypeCongeByDemande(@PathVariable int id)
    {
        return demandePieceRepository.getTypePieceByDemandePiece(id);
    }

    @GetMapping("/getall")
    public List<DemandePiece> getDemandesPiece(){
        return demandePieceService.getDemandesPiece();
    }

    @PostMapping("/add/{id_emp}/{id_piece}")
    public DemandePiece addDemandePiece(@RequestBody DemandePiece demandePiece, @PathVariable int id_emp, @PathVariable int id_piece){
        return demandePieceService.addDemandePiece(demandePiece, id_emp, id_piece);
    }

    @PutMapping("/update/{id}")
    public DemandePiece updateDemandePiece(@PathVariable int id,@RequestBody DemandePiece demandePiece){
        return demandePieceService.updateDemandePiece(id,demandePiece);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDemandePiece(@PathVariable int id){
        return demandePieceService.deleteDemangePiece(id);
    }
}
