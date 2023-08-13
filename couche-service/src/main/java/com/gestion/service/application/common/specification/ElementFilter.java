package com.gestion.service.application.common.specification;

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
