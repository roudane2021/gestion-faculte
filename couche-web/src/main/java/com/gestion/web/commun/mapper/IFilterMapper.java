package com.gestion.web.commun.mapper;

import com.gestion.service.application.departement.models.DepartementFilter;
import com.gestion.web.commun.filter.FiltersDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IFilterMapper {

    DepartementFilter toFilters(FiltersDto filtersDto);
}
