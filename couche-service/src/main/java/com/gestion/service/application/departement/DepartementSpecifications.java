package com.gestion.service.application.departement;

import com.gestion.model.entities.DepartementEntity;
import com.gestion.service.application.departement.models.DepartementFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.Predicate;

public class DepartementSpecifications {

    public static Specification<DepartementEntity> specification(DepartementFilter departementFilter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (departementFilter != null) {
                if (StringUtils.isNotEmpty(departementFilter.getCode())) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("code"), departementFilter.getCode()));
                }
                if (StringUtils.isNotEmpty(departementFilter.getNom())) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("nom"), departementFilter.getNom()));
                }
                if (StringUtils.isNotEmpty(departementFilter.getLibelle())) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("libelle"), departementFilter.getLibelle()));
                }
            }

            return predicate;
        };
    }
}
