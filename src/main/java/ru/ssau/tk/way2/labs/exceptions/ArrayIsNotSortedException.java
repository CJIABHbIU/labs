package ru.ssau.tk.way2.labs.exceptions;

import java.io.Serializable;

public class ArrayIsNotSortedException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1284061617381430106L;

    public ArrayIsNotSortedException() {

    }

    public ArrayIsNotSortedException(String massage) {
        super(massage);
    }
}
