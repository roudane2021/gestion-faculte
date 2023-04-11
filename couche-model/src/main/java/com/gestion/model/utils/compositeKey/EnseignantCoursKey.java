package com.gestion.model.utils.compositeKey;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EnseignantCoursKey implements Serializable {

    @Column(name = "cours_code")
    private String coursCode;

    @Column(name = "enseignant_matrucle")
    private String enseignantMatrucle;
}
