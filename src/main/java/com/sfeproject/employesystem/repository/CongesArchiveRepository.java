package com.sfeproject.employesystem.repository;

import com.sfeproject.employesystem.model.CongesArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CongesArchiveRepository extends JpaRepository<CongesArchive, Integer>, JpaSpecificationExecutor<CongesArchive> {
}
