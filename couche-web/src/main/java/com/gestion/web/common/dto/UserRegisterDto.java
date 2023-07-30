package com.gestion.web.common.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegisterDto {
    @NotBlank(message = "Username must not be blank")
    private String username;
    @Email(message = "Must Be email")
    private String email;
    @NotNull(message = "The password is required.")
    @Size(min = 8, max = 9, message = "password must be between 8 and 30")
    private String password;
    @Size(min = 10, max = 10, message = "telephone must be 10 size")
    private String telephone;
    @Past(message = "The  date must be  in the past.")
    private LocalDate dateNaissance;
}
