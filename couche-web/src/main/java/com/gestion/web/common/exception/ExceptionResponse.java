package com.gestion.web.common.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private String mensaje;
    private String detalles;
    private String httpCodeMessage;
    private Map<String, String> errors;
}
