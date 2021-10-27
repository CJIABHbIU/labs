package ru.ssau.tk.way2.labs.exceptions;

public class DifferentLengthOfArraysException extends RuntimeException{
    public DifferentLengthOfArraysException(){

    }
    public DifferentLengthOfArraysException(String massage){
        super(massage);
    }
}
