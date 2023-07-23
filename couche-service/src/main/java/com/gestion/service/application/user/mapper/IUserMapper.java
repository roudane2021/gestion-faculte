package com.gestion.service.application.user.mapper;

import com.gestion.model.entities.UserEntity;
import com.gestion.service.application.user.model.UserApplication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserEntity userEntity(UserApplication userApplication);
    UserApplication  userApp(UserEntity userEntity);
}
