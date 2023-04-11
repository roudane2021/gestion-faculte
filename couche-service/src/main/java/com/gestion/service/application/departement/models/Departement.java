package com.gestion.service.application.departement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departement {
    private String code;
    private String nom;
    private String libelle;
}
