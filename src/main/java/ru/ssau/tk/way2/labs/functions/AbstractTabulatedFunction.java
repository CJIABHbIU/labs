package ru.ssau.tk.way2.labs.functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {
    protected int count = 0;

    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x);

    protected abstract double extrapolateRight(double x);

    protected abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return (leftY + (rightY - leftY) / (rightX - leftX) * (x - leftX));
    }

    @Override
    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        }
        if (x > rightBound()) {
            return extrapolateRight(x);
        }
        if (indexOfX(x) == -1) {
            return interpolate(x, floorIndexOfX(x));
        }
        return getY(indexOfX(x));
    }
    static protected void checkLengthIsTheSame(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) {
            throw new DifferentLengthOfArraysException("Lengths of arrays are different");
        }
    }
    static protected void checkSorted(double[] xValues) {
        for (int i = 0; i < xValues.length - 1; i++) {
            if (xValues[i] >= xValues[i + 1]) {
                throw new ArrayIsNotSortedException("xValues array isn't sorted");
            }
        }
    }
}
