package com.gestion.service.application.commun.specification;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ElementFilter {
    private String cle;
    private String value;
    private Operation operation;
}
