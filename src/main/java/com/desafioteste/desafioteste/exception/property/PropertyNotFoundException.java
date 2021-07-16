package com.desafioteste.desafioteste.exception.property;

public class PropertyNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 2L;

    public PropertyNotFoundException(String mensagem) {
        super(mensagem);
    }
    public PropertyNotFoundException(Exception e) {
        super(e);
    }

}
