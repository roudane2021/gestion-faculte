package com.gestion.web.common.exception;

import com.gestion.service.application.common.execption.GestionException;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GestionException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(GestionException ex, WebRequest request, HttpStatus status) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timestamp(LocalDateTime.now())
                                                                           .mensaje(ex.getMessage())
                                                                           .detalles(request.getDescription(false))
                                                                            .httpCodeMessage(status.getReasonPhrase())
                                                                           .build();
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                                    .collect(Collectors.toMap(DefaultMessageSourceResolvable::getDefaultMessage, p -> StringUtils.arrayToDelimitedString(p.getArguments(), ",")));

        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timestamp(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(false))
                .httpCodeMessage(status.getReasonPhrase())
                .errors(errors)
                .build();


        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, 0);
        }

        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timestamp(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(false))
                .httpCodeMessage(status.getReasonPhrase())
                .build();
        return new ResponseEntity<>(exceptionResponse, headers, status);
    }

    @ExceptionHandler(IdentifierGenerationException.class)
    public ResponseEntity<Object> handleIdentifierGenerationException(
            IdentifierGenerationException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timestamp(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(false))
                .httpCodeMessage(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .build();

        // Retourner une réponse avec l'objet d'erreur personnalisé
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}