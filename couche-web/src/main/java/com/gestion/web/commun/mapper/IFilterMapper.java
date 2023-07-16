package com.gestion.web.commun.mapper;

import com.gestion.service.application.commun.specification.Filters;
import com.gestion.web.commun.filter.FiltersDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IFilterMapper {

    Filters toFilters(FiltersDto filtersDto);
}
