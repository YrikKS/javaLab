package com.company;

public class MyExeption extends Exception{

    public MyExeption(String message){
        super(message);
    }

    public MyExeption(String message, Throwable cause){
        super(message, cause);
    }

}
