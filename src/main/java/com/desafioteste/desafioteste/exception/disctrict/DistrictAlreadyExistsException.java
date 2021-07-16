package com.desafioteste.desafioteste.exception.disctrict;

public class DistrictAlreadyExistsException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 3L;

    public DistrictAlreadyExistsException(String mensagem) {
        super(mensagem);
    }
    public DistrictAlreadyExistsException(Exception e) {
        super(e);
    }
}
