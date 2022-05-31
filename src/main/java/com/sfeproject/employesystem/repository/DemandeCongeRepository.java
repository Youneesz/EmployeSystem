package com.sfeproject.employesystem.repository;

import com.sfeproject.employesystem.model.DemandeConge;
import com.sfeproject.employesystem.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Integer>, JpaSpecificationExecutor<DemandeConge> {



}