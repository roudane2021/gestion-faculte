package com.gestion.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DepartementEntity {
    @Id
    @Column(name = "code",length = 255)
    private String code;
    @Column(name = "nom",length = 255)
    private String nom;
    @Column(name = "libelle",length = 255)
    private String libelle;
}
