package com.gestion.model.entities;

import com.gestion.model.utils.compositeKey.EtudiantCoursKey;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "etudiant_cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EtudiantCoursEntity implements Serializable {

    @EmbeddedId
    private EtudiantCoursKey id;

    @ManyToOne
    @MapsId("etudiantCodeApoge")
    @JoinColumn(name = "etudiant_code_apoge")
    private UserEntity etudiant;

    @ManyToOne
    @MapsId("coursCode")
    @JoinColumn(name = "cours_code")
    private CoursEntity cours;

    private Integer anneeUnivirsite;
    private Double note;
}
