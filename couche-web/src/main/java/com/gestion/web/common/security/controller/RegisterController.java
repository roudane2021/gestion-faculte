package com.gestion.web.common.security.controller;

import com.gestion.service.application.user.IUserApplication;
import com.gestion.web.common.dto.UserRegisterDto;
import com.gestion.web.common.security.mapper.IUserDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
public class RegisterController {

    private final IUserApplication userApplication;
    private final IUserDtoMapper userDtoMapper;

    public RegisterController(IUserApplication userApplication, IUserDtoMapper userDtoMapper) {
        this.userApplication = userApplication;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping
    public String register(@RequestBody final UserRegisterDto userRegisterDto) {
        UserRegisterDto registerDto = userDtoMapper.userDto(userApplication.save(userDtoMapper.userApplication(userRegisterDto)));
        return registerDto.getUsername();
    }


}
