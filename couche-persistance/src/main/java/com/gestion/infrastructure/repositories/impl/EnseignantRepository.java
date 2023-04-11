package com.gestion.infrastructure.repositories.impl;

import com.gestion.model.entities.EnseignantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<EnseignantEntity, String> {
}
