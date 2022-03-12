package com.company.Exeptions;

public class CommandExceptions extends Exception{
    public CommandExceptions(String message){
        super(message);
    }

    public CommandExceptions(String message, Throwable cause){
        super(message, cause);
    }

}