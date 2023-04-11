package com.gestion.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EtudiantEntity implements Serializable {

    @Id
    @Column(name = "code_apoge",length = 255)
    private String codeApoge;
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
    @OneToMany(mappedBy = "etudiant")
    Set<EtudiantCoursEntity> etudiantCours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_code", referencedColumnName = "code")
    private DepartementEntity departement;
}
