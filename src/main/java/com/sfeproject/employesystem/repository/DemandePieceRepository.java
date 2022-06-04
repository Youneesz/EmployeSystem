package com.sfeproject.employesystem.repository;

import com.sfeproject.employesystem.model.DemandePiece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface DemandePieceRepository extends JpaRepository<DemandePiece, Integer>, JpaSpecificationExecutor<DemandePiece> {

    @Query(value = "select b.intitule_piece from demande_piece a inner join piece b on a.code_piece = b.code_piece and a.num_demandepiece = ?1", nativeQuery = true)
    public String getTypePieceByDemandePiece(int id);
}