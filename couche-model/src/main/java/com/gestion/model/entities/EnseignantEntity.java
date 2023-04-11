package com.gestion.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "enseignant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EnseignantEntity {
    @Id
    @Column(name = "matrucle",length = 255)
    private String matrucle;
    @Column(name = "nom",length = 255)
    private String nom;
    @Column(name = "prenom",length = 255)
    private String prenom;
    @Column(name = "email",length = 255,unique = true,nullable = false)
    private String email;
    @Column(name = "telephone",length = 255,unique = true)
    private String telephone;
    @Column(name = "date_naissance",length = 255)
    private LocalDate dateNaissance;
    @OneToMany(mappedBy = "enseignant")
    Set<EnseignantCoursEntity> enseignantCours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_code", referencedColumnName = "code")
    private DepartementEntity departement;
}
