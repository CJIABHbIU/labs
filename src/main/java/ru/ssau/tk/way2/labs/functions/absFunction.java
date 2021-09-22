package ru.ssau.tk.way2.labs.functions;

public class absFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.abs(x);
    }
}
