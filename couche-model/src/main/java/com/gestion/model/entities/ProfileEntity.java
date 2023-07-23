package com.gestion.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profile_app")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProfileEntity {

    @Id
    @Column(name = "code",length = 50)
    private String code;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "profile_role",
            joinColumns = @JoinColumn(name = "profile_code" ),
            inverseJoinColumns = @JoinColumn(name = "role_code"))
    private Set<RoleEntity> roleEntities =new HashSet<>();

   /*
   * supprimme la table user_role et remplace par profile_role
   * */
}
