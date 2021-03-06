package ru.ssau.tk.way2.labs.operations;

import ru.ssau.tk.way2.labs.concurrent.SynchronizedTabulatedFunction;
import ru.ssau.tk.way2.labs.functions.Point;
import ru.ssau.tk.way2.labs.functions.TabulatedFunction;
import ru.ssau.tk.way2.labs.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.way2.labs.functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {
    TabulatedFunctionFactory factory;

    public TabulatedDifferentialOperator() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    @Override
    public TabulatedFunction derive(TabulatedFunction function) {

        Point[] points = TabulatedFunctionOperationService.asPoints(function);
        int length = points.length;

        double[] xValues = new double[length];
        double[] yValues = new double[length];

        for (int i = 0; i < length - 1; i++) {
            yValues[i] = (points[i + 1].y - points[i].y) / (points[i + 1].x - points[i].x);
            xValues[i] = points[i].x;
        }

        yValues[length - 1] = yValues[length - 2];
        xValues[length - 1] = points[length - 1].x;

        return factory.create(xValues, yValues);
    }

    public TabulatedFunction deriveSynchronously(TabulatedFunction function) {
        Object mu = new Object();

        if (function instanceof SynchronizedTabulatedFunction) {
            return ((SynchronizedTabulatedFunction) function).doSynchronously(this::derive);
        }
        SynchronizedTabulatedFunction syncFunc = new SynchronizedTabulatedFunction(function, mu);
        return syncFunc.doSynchronously(this::derive);
    }
}
