package com.gestion.infrastructure.repositories.impl;

import com.gestion.model.entities.EnseignantCoursEntity;
import com.gestion.model.utils.compositeKey.EnseignantCoursKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantCoursRepository extends JpaRepository<EnseignantCoursEntity, EnseignantCoursKey> {
}
