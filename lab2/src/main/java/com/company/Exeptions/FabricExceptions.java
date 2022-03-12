package com.company.Exeptions;

public class FabricExceptions extends Exception {
    public FabricExceptions(String message) {
        super(message);
    }

    public FabricExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}
