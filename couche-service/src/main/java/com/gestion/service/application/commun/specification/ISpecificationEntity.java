package com.gestion.service.application.commun.specification;

import org.springframework.data.jpa.domain.Specification;

public interface ISpecificationEntity<T> {

 Specification<T> generateSpecification(Filters filters);
}
