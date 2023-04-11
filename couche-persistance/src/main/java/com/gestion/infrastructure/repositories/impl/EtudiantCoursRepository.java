package com.gestion.infrastructure.repositories.impl;

import com.gestion.model.entities.EtudiantCoursEntity;
import com.gestion.model.utils.compositeKey.EtudiantCoursKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantCoursRepository extends JpaRepository<EtudiantCoursEntity, EtudiantCoursKey> {
}
