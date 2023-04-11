package com.gestion.infrastructure.repositories.impl;

import com.gestion.model.entities.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtudiantRepository extends JpaRepository<EtudiantEntity, String> {
}
