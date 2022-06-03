package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.PieceJointe;

import java.util.List;

public interface PieceJointeService {

    public List<PieceJointe> getPiecesByActualite(int idActualite);
    public PieceJointe addPieceJointe(PieceJointe pieceJointe);
    public PieceJointe getPieceJointe(int id);
    public List<PieceJointe> getPieceJointes();
    public String deletePieceJointe(int id);
    public PieceJointe updatePieceJointe(int id, PieceJointe pieceJointe);
    public List<PieceJointe> getPiecesJointes();
}
