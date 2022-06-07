package com.sfeproject.employesystem.repository;

import com.sfeproject.employesystem.model.PiecesArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PiecesArchiveRepository extends JpaRepository<PiecesArchive, Integer>, JpaSpecificationExecutor<PiecesArchive> {
}
