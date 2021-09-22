package ru.ssau.tk.way2.labs.functions;

public class ConstantFunction implements MathFunction {
    private final double constanta;

    public ConstantFunction(double x) {
        constanta = x;
    }

    public ConstantFunction() {
        constanta = 0;
    }


    @Override
    public double apply(double x) {
        return constanta;
    }
}

class ZeroFunction extends ConstantFunction {
    public ZeroFunction() {
    }

    @Override
    public double apply(double x) {
        return 0;
    }
}

class UnoFunction extends ConstantFunction {

    public UnoFunction() {
    }

    @Override
    public double apply(double x) {
        return 1;
    }
}