package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.DemandePiece;
import com.sfeproject.employesystem.repository.EmployeRepository;
import com.sfeproject.employesystem.repository.PieceRepository;
import com.sfeproject.employesystem.repository.DemandePieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandePieceServiceImpl implements DemandePieceService{

    @Autowired
    private DemandePieceRepository demandePieceRepository;

    @Autowired
    private PieceRepository pieceRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public DemandePiece getDemangePiece(int id) {
        return demandePieceRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<DemandePiece> getDemandesPiece() {
        return demandePieceRepository.findAll();
    }

    @Override
    public DemandePiece addDemandePiece(DemandePiece demandePiece, int id_emp, int id_piece) {
        for (DemandePiece d: demandePieceRepository.findAll()) {
            if(d.equals(demandePiece))
                return null;
        }
        demandePiece.setPiece(pieceRepository.findById(id_piece).orElseThrow(RuntimeException::new));
        demandePiece.setEmployee(employeRepository.findById(id_emp).orElseThrow(RuntimeException::new));
        demandePiece.setEtatDemande("nouveau");
        return demandePieceRepository.save(demandePiece);
    }

    @Override
    public DemandePiece updateDemandePiece(int id, DemandePiece demandePiece) {
        for (DemandePiece d: demandePieceRepository.findAll()) {
            if(d.equals(demandePiece))
                return null;
        }
        DemandePiece temp = demandePieceRepository.findById(id).orElseThrow(RuntimeException::new);
        temp.setDateEtat(demandePiece.getDateEtat());
        temp.setPiece(demandePiece.getPiece());
        temp.setDateDemande(demandePiece.getDateDemande());
        temp.setMotifRefus(demandePiece.getMotifRefus());
        temp.setEtatDemande(demandePiece.getEtatDemande());

        return null;
    }

    @Override
    public String deleteDemangePiece(int id) {
        try{
            demandePieceRepository.deleteById(id);
            return "demande supprimée avec succès !!";
        }catch(EmptyResultDataAccessException e){
            return "cet identifiant n'existe pas" ;
        }
    }
}
