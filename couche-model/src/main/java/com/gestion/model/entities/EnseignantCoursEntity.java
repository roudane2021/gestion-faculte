package com.gestion.model.entities;

import com.gestion.model.utils.compositeKey.EnseignantCoursKey;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "enseignant_cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EnseignantCoursEntity implements Serializable {
    @EmbeddedId
    private EnseignantCoursKey id;

    @ManyToOne
    @MapsId("etudiantCodeApoge")
    @JoinColumn(name = "enseignant_matrucle")
    private UserEntity enseignant;

    @ManyToOne
    @MapsId("coursCode")
    @JoinColumn(name = "cours_code")
    private CoursEntity cours;
    @Column(name = "annee_univirsite", length = 4)
    private Integer anneeUnivirsite;
}
