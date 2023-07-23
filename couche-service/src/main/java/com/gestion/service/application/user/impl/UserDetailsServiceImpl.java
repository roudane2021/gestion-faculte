package com.gestion.service.application.user.impl;

import com.gestion.infrastructure.repositories.impl.UserRepository;
import com.gestion.model.entities.UserEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;



    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(" element Not Found"));
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (Objects.nonNull(userEntity) && Objects.nonNull(userEntity.getProfileEntity())  && CollectionUtils.isNotEmpty(userEntity.getProfileEntity().getRoleEntities()) ) {
            userEntity.getProfileEntity().getRoleEntities().forEach(roleApp -> {
                GrantedAuthority role = new SimpleGrantedAuthority(roleApp.getRoleName());
                authorities.add(role);
            });
        }
        UserDetails user = User.builder().username(userEntity.getEmail()).authorities(authorities).password(userEntity.getPassword()).build();
        return user;
    }


}
