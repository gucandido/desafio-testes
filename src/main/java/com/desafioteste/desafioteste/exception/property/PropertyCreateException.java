package com.desafioteste.desafioteste.exception.property;

public class PropertyCreateException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 6L;

    public PropertyCreateException(String mensagem) {
        super(mensagem);
    }
    public PropertyCreateException(Exception e) {
        super(e);
    }

}
