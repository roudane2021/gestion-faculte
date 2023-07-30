package com.gestion.service.application.user.model;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserApplication {
    private String username;
    private String email;
    private String password;
    private String telephone;
    private LocalDate dateNaissance;
}
