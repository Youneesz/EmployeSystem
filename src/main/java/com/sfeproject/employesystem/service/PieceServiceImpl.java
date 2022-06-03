package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.Piece;
import com.sfeproject.employesystem.repository.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceServiceImpl implements PieceService {


    @Autowired
    private PieceRepository pieceRepository;


    @Override
    public Piece getPiece(int id) {
        return pieceRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Piece> getPieces() {
        return pieceRepository.findAll();
    }

    @Override
    public Piece updatePiece(int id, Piece piece) {
        for (Piece p : pieceRepository.findAll()) {
            if (p.getDescriptionPiece().equals(piece.getDescriptionPiece())
                    && p.getIntitulePiece().equals(piece.getIntitulePiece())) {
                return null;
            }
        }
        Piece tempConge = pieceRepository.findById(id).orElseThrow(RuntimeException::new);
        tempConge.setDescriptionPiece(piece.getDescriptionPiece());
        tempConge.setIntitulePiece(piece.getIntitulePiece());
        return pieceRepository.save(tempConge);
    }

    @Override
    public Piece savePiece(Piece piece) {
        for (Piece p : pieceRepository.findAll()) {
            if (p.getDescriptionPiece().equals(piece.getDescriptionPiece())
                    && p.getIntitulePiece().equals(piece.getIntitulePiece())) {
                return null;
            }
        }
        return pieceRepository.save(piece);
    }

    @Override
    public String deletePiece(int id) {
        try{
            pieceRepository.deleteById(id);
            return "Piece supprimée avec succes !!";
        }catch(EmptyResultDataAccessException e){
            return "Cet identifiant n'existe pas !!";
        }
    }
}
