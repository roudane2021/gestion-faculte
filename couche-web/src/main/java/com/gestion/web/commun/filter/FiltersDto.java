package com.gestion.web.commun.filter;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class FiltersDto {

    private Set<ElementFilterDto> elementFilters;
}
