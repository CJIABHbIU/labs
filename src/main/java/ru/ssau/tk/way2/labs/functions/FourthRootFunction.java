package ru.ssau.tk.way2.labs.functions;

public class FourthRootFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return (Math.sqrt(Math.sqrt(x)));
    }
}
