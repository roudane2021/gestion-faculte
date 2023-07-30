package com.gestion.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "user_app")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserEntity {

    @Id
    @Column(name = "code",length = 50)
    private String code;
    @Column(name = "username",length = 50)
    private String username;
    @Column(name = "password",length = 500)
    private String password;

    @Column(name = "nom",length = 50)
    private String nom;
    @Column(name = "prenom",length = 50)
    private String prenom;
    @Column(name = "email",length = 50,unique = true,nullable = false)
    private String email;
    @Column(name = "telephone",length = 50,unique = true)
    private String telephone;
    @Column(name = "date_naissance",length = 50)
    private LocalDate dateNaissance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_code", referencedColumnName = "code")
    private ProfileEntity profileEntity;

    @OneToMany(mappedBy = "enseignant")
    Set<EnseignantCoursEntity> enseignantCours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_code_enseignant", referencedColumnName = "code")
    private DepartementEntity departementEnseignant;

    @OneToMany(mappedBy = "etudiant")
    Set<EtudiantCoursEntity> etudiantCours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_code_etudiant", referencedColumnName = "code")
    private DepartementEntity departementEtudiant;
}
