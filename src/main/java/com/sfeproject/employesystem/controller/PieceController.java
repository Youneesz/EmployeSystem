package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.Piece;
import com.sfeproject.employesystem.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pieces")
@CrossOrigin
public class PieceController {

    @Autowired
    private PieceService pieceService;

    @GetMapping("/get/{id}")
    public Piece getPiece(@PathVariable int id) {
        return pieceService.getPiece(id);
    }

    @GetMapping("/getall")
    public List<Piece> getAll() {
        return pieceService.getPieces();
    }

    @PostMapping("/add")
    public Piece addPiece(@RequestBody Piece piece) {
        return pieceService.savePiece(piece);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePiece(@PathVariable int id) {
        return pieceService.deletePiece(id);
    }

    @PutMapping("/update/{id}")
    public Piece updatePiece(@RequestBody Piece piece, @PathVariable int id) {
        return pieceService.updatePiece(id, piece);
    }
}
