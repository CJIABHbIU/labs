package ru.ssau.tk.way2.labs.exceptions;

import java.io.Serializable;

public class InterpolationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 6186364753791328859L;

    public InterpolationException() {
    }

    public InterpolationException(String massage) {
        super(massage);
    }
}
