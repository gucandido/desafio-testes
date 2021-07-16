package com.desafioteste.desafioteste.exception.property;

public class PropertyAlreadyExists extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 5L;

    public PropertyAlreadyExists(String mensagem) {
        super(mensagem);
    }
    public PropertyAlreadyExists(Exception e) {
        super(e);
    }

}
