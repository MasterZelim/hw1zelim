package com.example2.hw2zelim.exception;

public class CSVQuestionException extends RuntimeException{


    public CSVQuestionException(String message){
        super(message);
    }

    public CSVQuestionException(String message, Throwable cause){
        super(message,cause);
    }
}
