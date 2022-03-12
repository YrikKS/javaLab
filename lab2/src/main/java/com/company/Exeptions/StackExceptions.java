package com.company.Exeptions;

public class StackExceptions extends Exception{
    public StackExceptions(String message){
        super(message);
    }

    public StackExceptions(String message, Throwable cause){
        super(message, cause);
    }

}
