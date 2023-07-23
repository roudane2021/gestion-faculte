package com.gestion.web.common.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private String username;
    private String password;
}
