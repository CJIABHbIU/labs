package ru.ssau.tk.way2.labs.functions.factory;

import ru.ssau.tk.way2.labs.functions.TabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);
}