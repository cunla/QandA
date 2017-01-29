package com.delirium.boiler.exceptions;

/**
 * Created by style on 29/01/2017.
 */
public class BoilerAppLoadingException extends RuntimeException {
    public BoilerAppLoadingException(Exception e) {
        super(e);
    }

    public BoilerAppLoadingException(String msg) {
        super(msg);
    }
}
