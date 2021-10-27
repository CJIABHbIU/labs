package ru.ssau.tk.way2.labs.operations;

import ru.ssau.tk.way2.labs.functions.MathFunction;

public class MiddleSteppingDifferentialOperator extends SteppingDifferentialOperator{
    public MiddleSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction func) {
        return x -> (func.apply(x + step) - func.apply(x - step)) / (2 * step);
    }
}
