package ru.nsu.lab1.Kurgin;

public class AnalyzerExeption extends Exception{

    public AnalyzerExeption(String message){
        super(message);
    }

    public AnalyzerExeption(String message, Throwable cause){
        super(message, cause);
    }

}
