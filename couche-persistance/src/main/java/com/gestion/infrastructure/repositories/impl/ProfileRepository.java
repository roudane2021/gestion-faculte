package com.gestion.infrastructure.repositories.impl;


import com.gestion.model.entities.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {
}
