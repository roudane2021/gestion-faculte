package com.gestion.service.application.departement.impl;

import com.gestion.infrastructure.repositories.impl.DepartementRepository;
import com.gestion.model.entities.DepartementEntity;
import com.gestion.service.application.commun.specification.Filters;
import com.gestion.service.application.commun.specification.ISpecificationEntity;
import com.gestion.service.application.commun.specification.SpecificationEntity;
import com.gestion.service.application.departement.DepartementSpecifications;
import com.gestion.service.application.departement.IDepartementApplication;
import com.gestion.service.application.departement.mapper.IDepartementMapper;
import com.gestion.service.application.departement.models.Departement;
import com.gestion.service.application.departement.models.DepartementFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class IDepartementApplicationImpl implements IDepartementApplication {
    private final  DepartementRepository departementRepository;
    private final IDepartementMapper departementMapper;

    private final ISpecificationEntity<DepartementEntity> specificationEntity;

    public IDepartementApplicationImpl(DepartementRepository departementRepository, IDepartementMapper departementMapper, ISpecificationEntity specificationEntity) {
        this.departementRepository = departementRepository;
        this.departementMapper = departementMapper;
        this.specificationEntity = specificationEntity;
    }

    @Override
    public Departement getDepartement(String code) {
        Optional<Departement> departementOptional = departementRepository.findById(code).map(departementMapper::depatement);
        return departementOptional.orElseGet(Departement::new);
    }

    @Override
    public Departement save(Departement departement) {
        DepartementEntity departementEntity = departementMapper.depatementEntity(departement);
        return departementMapper.depatement(departementRepository.save(departementEntity));
    }
    @Override
    public Page<Departement> searchDepartements(Pageable pageable, Filters filters) {
        Specification<DepartementEntity> specification = this.specificationEntity.generateSpecification(filters);
        Page<DepartementEntity> departementEntityPage = departementRepository.findAll(specification, pageable);
        return departementEntityPage.map(entity -> departementMapper.depatement(entity));
    }

    @Override
    public List<Departement> listOfAllDepartement() {
        List<Departement> departements = departementMapper.depatements(departementRepository.findAll());
        return departements;
    }
}
