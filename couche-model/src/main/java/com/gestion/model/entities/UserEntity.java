package com.gestion.model.entities;

import lombok.*;

import javax.persistence.*;


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
    @Column(name = "email",length = 50)
    private String email;
    @Column(name = "password",length = 500)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_code", referencedColumnName = "code")
    private ProfileEntity profileEntity;
}
