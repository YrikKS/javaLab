package com.company.Exeptions;

public class FileInException extends Exception{
    public FileInException(String message){
        super(message);
    }

    public FileInException(String message, Throwable cause){
        super(message, cause);
    }
}
