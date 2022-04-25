package com.sfeproject.employesystem.repository;

import com.sfeproject.employesystem.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>, JpaSpecificationExecutor<Categorie> {

}