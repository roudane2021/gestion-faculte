package com.gestion.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "semistre")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SemistreEntity {
    @Id
    @Column(name = "code",length = 255)
    private String code;
    @Column(name = "nom",length = 255)
    private String nom;
    @Column(name = "libelle",length = 255)
    private String libelle;
    @Column(name = "annee_univirsite",length = 4)
    private Integer anneeUnivirsite;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_code", referencedColumnName = "code")
    private DepartementEntity departement;
}
