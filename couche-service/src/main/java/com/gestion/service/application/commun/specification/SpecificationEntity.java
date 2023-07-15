package com.gestion.service.application.commun.specification;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.criteria.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SpecificationEntity<T>  implements ISpecificationEntity<T>{

    @Override
    public   Specification<T> generateSpecification(Filters filters) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (filters != null && CollectionUtils.isNotEmpty(filters.getElementFilters())) {
                Set<ElementFilter> elementFilter = filters.getElementFilters()
                        .stream().filter(el -> {
                            return el != null && el.getOperation() != null && StringUtils.isNotBlank(el.getCle()) && StringUtils.isNotBlank(el.getValue())
                                    && isFieldExists(el.getCle(), getEntityFields(root.getJavaType()));
                        }).collect(Collectors.toSet());
                for (ElementFilter element : elementFilter) {
                    predicate = constructPredicate(predicate, criteriaBuilder, root, element);
                }
            }

            return predicate;
        };
    }

    private static <T> Predicate constructPredicate(Predicate predicate, CriteriaBuilder criteriaBuilder, Root<T> root, ElementFilter element) {
        Field field = getField(element.getCle(), getEntityFields(root.getJavaType()));
        String fieldName = element.getCle();
        Predicate predicateAdd;
        if (!isFieldAnnotatedWithEntity(field)) {
            Object value = transferType(root, element);
            Expression<?> fieldExpression = root.get(element.getCle());

            switch (element.getOperation()) {
                case GT:
                    predicateAdd = criteriaBuilder.gt((Expression<? extends Number>) fieldExpression, (Number) value);
                    break;
                case LT:
                    predicateAdd = criteriaBuilder.lt((Expression<? extends Number>) fieldExpression, (Number) value);
                    break;
                default:
                    predicateAdd = criteriaBuilder.equal(fieldExpression, value);
            }
        } else {
            Join<T, ?> join = root.join(fieldName, JoinType.INNER);
            predicateAdd = criteriaBuilder.equal(join.get("code"), element.getValue());
        }
        return criteriaBuilder.and(predicate, predicateAdd);
    }

    private static <T> Object transferType(Root<T> root, ElementFilter element) {
        Class<?> cl = root.get(element.getCle()).getJavaType();
        if (Integer.class.isAssignableFrom(cl)) {
            return Integer.valueOf(element.getValue());
        } else if (Double.class.isAssignableFrom(cl)) {
            return Double.valueOf(element.getValue());
        } else {
            return element.getValue();
        }
    }

    private static <T> List<Field> getEntityFields(Class<T> entityClass) {
        return Arrays.stream(entityClass.getDeclaredFields())
                .collect(Collectors.toList());
    }

    private static boolean isFieldExists(String fieldName, List<Field> fields) {
        return fields.stream()
                .anyMatch(field -> StringUtils.equals(fieldName, field.getName()));
    }

    private static Field getField(String fieldName, List<Field> fields) {
        return fields.stream()
                .filter(field -> StringUtils.equals(fieldName, field.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Field not found: " + fieldName));
    }

    public static boolean isFieldAnnotatedWithEntity(Field field) {
        Annotation[] annotations = field.getDeclaredAnnotations();
        return Arrays.stream(annotations)
                .anyMatch(annotation -> annotation.annotationType() == Entity.class);
    }
}