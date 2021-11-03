package ru.ssau.tk.way2.labs.exceptions;

import java.io.Serializable;

public class DifferentLengthOfArraysException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 3164159764233763709L;

    public DifferentLengthOfArraysException() {

    }

    public DifferentLengthOfArraysException(String massage) {
        super(massage);
    }
}
