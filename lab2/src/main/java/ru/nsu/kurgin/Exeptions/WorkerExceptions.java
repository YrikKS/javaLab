package ru.nsu.kurgin.Exeptions;

/**
 * this exception is triggered in classes inherited from Worker.
 */
public class WorkerExceptions extends Exception{

    public WorkerExceptions(String message){
        super(message);
    }

    public WorkerExceptions(String message, Throwable cause){
        super(message, cause);
    }

}
