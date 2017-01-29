package com.delirium.boiler.exceptions;

/**
 * Created by Daniel Moran on 1/14/2015.
 */
public class BoilerAppException extends RuntimeException {
    public BoilerAppException(String msg) {
        super(msg);
    }

    public BoilerAppException(Exception e) {
        super(e);
    }
}
