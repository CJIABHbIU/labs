package ru.ssau.tk.way2.labs.operations;

import ru.ssau.tk.way2.labs.functions.MathFunction;

public class RightSteppingDifferentialOperator extends SteppingDifferentialOperator{
    public RightSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction func) {
        return x -> (func.apply(x + step) - func.apply(x)) / step;
    }
}
