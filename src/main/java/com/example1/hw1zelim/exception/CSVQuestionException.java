package com.example1.hw1zelim.exception;

public class CSVQuestionException extends RuntimeException{


    public CSVQuestionException(String message){
        super(message);
    }

    public CSVQuestionException(String message, Throwable cause){
        super(message,cause);
    }
}
