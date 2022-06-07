package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.DemandePiece;

import java.util.List;

public interface DemandePieceService {

    public DemandePiece getDemangePiece(int id);
    public List<DemandePiece> getDemandesPiece();
    public DemandePiece addDemandePiece(DemandePiece demandePiece, int id_emp, int id_piece);
    public DemandePiece updateDemandePiece(int id, DemandePiece demandePiece);
    public String deleteDemandePiece(int id);
}

