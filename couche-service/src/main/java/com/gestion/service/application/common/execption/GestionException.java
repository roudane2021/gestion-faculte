package com.gestion.service.application.common.execption;



public class GestionException extends  RuntimeException{

    private String message;

    public GestionException(String message) {
        super(message);
        this.message = message;
    }


}
