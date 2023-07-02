package com.gestion.web.departement.mapper;

import com.gestion.service.application.departement.models.Departement;
import com.gestion.web.departement.dto.DepartementDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDepartementDtoMapper {

    DepartementDto departementDto(Departement departement);
    List<DepartementDto> departementDtos(List<Departement> departements);

    Departement departement(DepartementDto departementDto);
    List<Departement> departements(List<DepartementDto> departementDtos);
}
