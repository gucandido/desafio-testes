package com.desafioteste.desafioteste.exception.property;

public class PropertyAlreadyExistsException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 5L;

    public PropertyAlreadyExistsException(String mensagem) {
        super(mensagem);
    }
    public PropertyAlreadyExistsException(Exception e) {
        super(e);
    }

}
