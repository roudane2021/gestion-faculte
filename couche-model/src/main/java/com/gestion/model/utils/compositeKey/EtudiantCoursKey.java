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
public class EtudiantCoursKey implements Serializable {

    @Column(name = "etudiant_code_apoge")
    private String etudiantCodeApoge;

    @Column(name = "cours_code")
    private String coursCode;

}