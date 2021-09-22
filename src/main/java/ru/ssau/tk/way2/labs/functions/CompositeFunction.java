package ru.ssau.tk.way2.labs.functions;

public class CompositeFunction implements MathFunction{
    private MathFunction firstFunction;
    private MathFunction secondFunction;

    public CompositeFunction(MathFunction FirstFunction, MathFunction SecondFunction) {
        this.firstFunction = FirstFunction;
        this.secondFunction = SecondFunction;
    }

    public CompositeFunction() {
    }

    @Override
    public double apply(double x) {
        return (secondFunction.apply(firstFunction.apply(x)));
    }
}
