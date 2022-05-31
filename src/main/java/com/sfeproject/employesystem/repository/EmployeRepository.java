package com.sfeproject.employesystem.repository;

import com.sfeproject.employesystem.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Integer>, JpaSpecificationExecutor<Employe> {
    public Optional<Employe> findEmployeByEmailEmp(String email);

}