package com.gestion.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_app")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RoleEntity {

    @Id
    @Column(name = "code",length = 50)
    private String code;
    @Column(name = "role_name",length = 50)
    private String roleName;
}
