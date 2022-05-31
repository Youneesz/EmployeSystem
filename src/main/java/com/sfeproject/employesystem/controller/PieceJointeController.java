package com.sfeproject.employesystem.controller;


import com.sfeproject.employesystem.model.PieceJointe;
import com.sfeproject.employesystem.service.PieceJointeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/piecesJointes")
public class PieceJointeController {

    @Autowired
    private PieceJointeService pieceJointeService;

    @GetMapping("/pieceJointeFiltred/{id}")
    public List<PieceJointe> getPieceJointesFiltred(@PathVariable int id) {
        return pieceJointeService.getPiecesByActualite(id);
    }

    @GetMapping("/getall")
    public List<PieceJointe> getPieceJointes() {
        return pieceJointeService.getPiecesJointes();
    }


    @GetMapping("/get/{id}")
    public PieceJointe getPieceJointe(@PathVariable int id) {
        return pieceJointeService.getPieceJointe(id);
    }

    @PostMapping("/add")
    public PieceJointe addPieceJointe(@RequestBody PieceJointe pieceJointe) {
        return pieceJointeService.addPieceJointe(pieceJointe);
    }
    @PutMapping("/update/{id}")
    public PieceJointe updatePieceJointe(@PathVariable int id, @RequestBody PieceJointe pieceJointe) {
        return pieceJointeService.updatePieceJointe(id, pieceJointe);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePieceJointe(@PathVariable int id) {
        return pieceJointeService.deletePieceJointe(id);
    }



}



