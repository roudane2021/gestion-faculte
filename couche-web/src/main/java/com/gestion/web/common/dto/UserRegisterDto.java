package com.gestion.web.common.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegisterDto {
    private String username;
    private String email;
    private String password;
}
