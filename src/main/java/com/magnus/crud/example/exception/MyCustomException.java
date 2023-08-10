package com.magnus.crud.example.exception;

public class MyCustomException extends RuntimeException{

    public MyCustomException(String msg,String name){
        super(name);
    }
}
