package com.gestion.web.common.security.mapper;

import com.gestion.service.application.user.model.UserApplication;
import com.gestion.web.common.dto.UserRegisterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserDtoMapper {

    UserRegisterDto userDto(UserApplication userApp);

    UserApplication userApplication(UserRegisterDto userRegisterDto);

}
