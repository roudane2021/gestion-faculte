package com.gestion.service.application.departement.impl;

import com.gestion.infrastructure.repositories.impl.DepartementRepository;
import com.gestion.model.entities.DepartementEntity;
import com.gestion.service.application.departement.IDepartementApplication;
import com.gestion.service.application.departement.mapper.IDepartementMapper;
import com.gestion.service.application.departement.models.Departement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IDepartementApplicationImpl implements IDepartementApplication {
    private final  DepartementRepository departementRepository;
    private final IDepartementMapper departementMapper;

    public IDepartementApplicationImpl(DepartementRepository departementRepository, IDepartementMapper departementMapper) {
        this.departementRepository = departementRepository;
        this.departementMapper = departementMapper;
    }

    @Override
    public Departement save(Departement departement) {
        DepartementEntity departementEntity = departementMapper.depatementEntity(departement);
        return departementMapper.depatement(departementRepository.save(departementEntity));
    }

    @Override
    public List<Departement> listOfAllDepartement() {
        List<Departement> departements = departementMapper.depatements(departementRepository.findAll());
        return departements;
    }
}
