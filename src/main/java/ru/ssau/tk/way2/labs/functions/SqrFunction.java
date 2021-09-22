package ru.ssau.tk.way2.labs.functions;

public class
SqrFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.pow(x, 2);
    }
}
