package com.gestion.infrastructure.repositories.impl;

import com.gestion.model.entities.DepartementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<DepartementEntity, String> {
}
