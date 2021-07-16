package com.desafioteste.desafioteste.exception.disctrict;

public class DistrictNotFoundException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DistrictNotFoundException(String mensagem) {
        super(mensagem);
    }
    public DistrictNotFoundException(Exception e) {
        super(e);
    }

}
