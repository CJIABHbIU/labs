package ru.ssau.tk.way2.labs.exceptions;

public class InterpolationException extends RuntimeException{
    public InterpolationException(){}
    public InterpolationException(String massage){
        super(massage);
    }
}
