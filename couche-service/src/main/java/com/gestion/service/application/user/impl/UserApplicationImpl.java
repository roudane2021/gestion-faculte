package com.gestion.service.application.user.impl;

import com.gestion.infrastructure.repositories.impl.UserRepository;
import com.gestion.model.entities.UserEntity;
import com.gestion.service.application.common.execption.GestionException;
import com.gestion.service.application.user.IUserApplication;
import com.gestion.service.application.user.mapper.IUserMapper;
import com.gestion.service.application.user.model.UserApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationImpl implements IUserApplication {
    private final UserRepository userRepository;
    private final IUserMapper userMapper;
    //private final BCryptPasswordEncoder passwordEncoder;

    public UserApplicationImpl(UserRepository userRepository, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserApplication save(UserApplication user) {
        UserEntity userEntity = this.userMapper.userEntity(user);
        userEntity.setCode("123456");
        return  this.userMapper.userApp(userRepository.save(userEntity));
    }

    @Override
    public UserApplication getUser(String username) {
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(() -> new GestionException(" User Not Found"));
        return this.userMapper.userApp(userEntity);
    }

}
