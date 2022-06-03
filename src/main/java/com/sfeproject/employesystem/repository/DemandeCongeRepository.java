package com.sfeproject.employesystem.repository;

import com.sfeproject.employesystem.model.DemandeConge;
import com.sfeproject.employesystem.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Integer>, JpaSpecificationExecutor<DemandeConge> {

    @Query(value = "select b.intitule_conge from demande_conge a inner join conge b on a.code_conge = b.code_conge and a.num_demande = ?1", nativeQuery = true)
    public String getTypeCongeByDemandeConge(int id);

}