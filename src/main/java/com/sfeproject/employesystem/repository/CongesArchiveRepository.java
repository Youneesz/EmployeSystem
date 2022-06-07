package com.sfeproject.employesystem.repository;

import com.sfeproject.employesystem.model.CongesArchive;
import com.sfeproject.employesystem.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface CongesArchiveRepository extends JpaRepository<CongesArchive, Integer>, JpaSpecificationExecutor<CongesArchive> {

    @Query(value = "select * from employe where code_emp = (select code_emp from conges_archive where num_demande = ?1)", nativeQuery = true)
    public Employe getEmployeOfTheArchivedConge(int id);
}
