package ru.ssau.tk.way2.labs.functions;

public class AbsFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.abs(x);
    }
}
