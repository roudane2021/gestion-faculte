package com.gestion.web.commun.filter;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ElementFilterDto {
    private String cle;
    private String value;
    private OperationDto operation;
}
