package com.gestion.web.departement.mapper;

import com.gestion.service.application.departement.models.Departement;
import com.gestion.service.application.departement.models.DepartementFilter;
import com.gestion.web.departement.dto.DepartementDto;
import com.gestion.web.departement.dto.DepartementFilterDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDepartementFilterDtoMapper {

    DepartementFilter departementDto(DepartementFilterDto departementFilterDto);
}
