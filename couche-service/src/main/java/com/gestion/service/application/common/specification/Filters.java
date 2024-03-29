package com.gestion.service.application.common.specification;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Filters {

    private Set<ElementFilter> elementFilters;
}
