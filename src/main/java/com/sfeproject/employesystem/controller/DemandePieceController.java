package com.sfeproject.employesystem.controller;


import com.sfeproject.employesystem.model.DemandePiece;

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

    @GetMapping("/get/{id}")
    public DemandePiece getDemandePiece(@PathVariable int id){
        return demandePieceService.getDemangePiece(id);
    }

    @GetMapping("/getall")
    public List<DemandePiece> getDemandesPiece(){
        return demandePieceService.getDemandesPiece();
    }

    @PostMapping("/add")
    public DemandePiece addDemandePiece(@RequestBody DemandePiece demandePiece){
        return demandePieceService.addDemandePiece(demandePiece);
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
