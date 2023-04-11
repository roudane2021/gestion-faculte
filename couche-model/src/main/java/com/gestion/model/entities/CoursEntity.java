package com.gestion.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CoursEntity implements Serializable {
    @Id
    @Column(name = "code",length = 255)
    private String code;
    @Column(name = "nom",length = 255)
    private String nom;
    @Column(name = "libelle",length = 255)
    private String libelle;
    @OneToMany(mappedBy = "cours")
    Set<EtudiantCoursEntity>  etudiantCours;
    @OneToMany(mappedBy = "cours")
    Set<EnseignantCoursEntity>  enseignantCours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semistre_code", referencedColumnName = "code")
    private SemistreEntity semistre;

}
