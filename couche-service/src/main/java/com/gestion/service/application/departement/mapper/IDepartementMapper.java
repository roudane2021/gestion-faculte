package com.gestion.service.application.departement.mapper;

import com.gestion.model.entities.DepartementEntity;
import com.gestion.service.application.departement.models.Departement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDepartementMapper {

    Departement depatement(DepartementEntity departementEntity);
    List<Departement> depatements(List<DepartementEntity> departementEntitys);

    DepartementEntity depatementEntity(Departement departement);
    List<DepartementEntity> depatementEntitys(List<Departement> departements);
}
