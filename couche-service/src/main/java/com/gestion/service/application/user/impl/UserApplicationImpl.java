package com.gestion.service.application.user.impl;

import com.gestion.infrastructure.repositories.impl.UserRepository;
import com.gestion.model.entities.UserEntity;
import com.gestion.service.application.user.IUserApplication;
import com.gestion.service.application.user.mapper.IUserMapper;
import com.gestion.service.application.user.model.UserApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationImpl implements IUserApplication {
    private final UserRepository userRepository;
    private final IUserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserApplicationImpl(UserRepository userRepository, IUserMapper userMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserApplication save(UserApplication user) {
        UserEntity userEntity = this.userMapper.userEntity(user);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setCode("123456");
        return  this.userMapper.userApp(userRepository.save(userEntity));
    }

}
