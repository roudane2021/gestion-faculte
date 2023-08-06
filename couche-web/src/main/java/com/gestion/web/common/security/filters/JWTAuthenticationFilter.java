package com.gestion.web.common.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.service.application.common.execption.GestionException;
import com.gestion.service.application.user.IUserApplication;
import com.gestion.web.common.dto.UserDto;
import com.gestion.web.common.security.utils.JwtTokenUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    private final  IUserApplication userApplication;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,JwtTokenUtil jwtTokenUtil,UserDetailsService userDetailsService, IUserApplication userApplication) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userApplication = userApplication;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            // Extraction des informations d'identification de la requête
            UserDto userDto = new ObjectMapper().readValue(request.getInputStream(),UserDto.class);

            // Création d'un objet UsernamePasswordAuthenticationToken avec les informations d'identification
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword());

            // Authentification de l'utilisateur via l'AuthenticationManager
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            throw new GestionException("Invalid username or password");
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
        throw new GestionException("Invalid username or password");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        final User user = (User) authResult.getPrincipal();
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String profile = Objects.nonNull(this.userApplication.getUser(user.getUsername())) && Objects.nonNull(this.userApplication.getUser(user.getUsername()).getProfile()) ? this.userApplication.getUser(user.getUsername()).getProfile().getCode() : "NONE";

        final String jwt = jwtTokenUtil.generateToken(userDetails, profile);
        //ce ligne qui permet a client de lire le jwt
        response.addHeader("Access-Control-Expose-Headers","authorization");
        response.addHeader(HttpHeaders.AUTHORIZATION,jwt);
    }
}
