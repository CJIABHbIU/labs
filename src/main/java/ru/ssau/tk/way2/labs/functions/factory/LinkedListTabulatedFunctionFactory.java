package ru.ssau.tk.way2.labs.functions.factory;

import ru.ssau.tk.way2.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.way2.labs.functions.MathFunction;
import ru.ssau.tk.way2.labs.functions.TabulatedFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory{
    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    @Override
    public TabulatedFunction create(MathFunction function, double xFrom, double xTo, int count) {
        return null;
    }
}
