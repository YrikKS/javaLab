package com.company.Exeptions;

public class WorkerExeption extends Exception{

    public WorkerExeption(String message){
        super(message);
    }

    public WorkerExeption(String message, Throwable cause){
        super(message, cause);
    }

}
