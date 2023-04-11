package com.gestion.infrastructure.repositories.impl;

import com.gestion.model.entities.CoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoursRepository extends JpaRepository<CoursEntity, String> {
}
