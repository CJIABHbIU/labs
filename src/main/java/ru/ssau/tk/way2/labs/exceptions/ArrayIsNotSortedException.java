package ru.ssau.tk.way2.labs.exceptions;

public class ArrayIsNotSortedException extends RuntimeException{
    public ArrayIsNotSortedException(){
        
    }
    public ArrayIsNotSortedException(String massage) {
        super(massage);
    }
}
