package com.gestion.web.departement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartementFilterDto {
    private String code;
    private String nom;
    private String libelle;
}
