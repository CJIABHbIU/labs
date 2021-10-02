package ru.ssau.tk.way2.labs.functions;

import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction {
    private double[] x;
    private double[] y;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        this.x = Arrays.copyOf(xValues, xValues.length);
        this.y = Arrays.copyOf(yValues, xValues.length);
        this.count = xValues.length;
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count == 1) {
            this.x = new double[]{xFrom};
            this.y = new double[]{source.apply(xFrom)};
            this.count = count;
            return;
        }
        double step = (xTo - xFrom) / (count - 1);
        double[] x = new double[count];
        double[] y = new double[count];
        for (int i = 0; i < count; i++) {
            x[i] = xFrom + i * step;
            y[i] = source.apply(xFrom + i * step);
        }
        this.x = Arrays.copyOf(x, count);
        this.y = Arrays.copyOf(y, count);
        this.count = count;
    }

    @Override
    protected int floorIndexOfX(double x) {
        int k = 0;
        for (int i = 0; i < this.count; i += 1)
            if (this.x[i] <= x) {
                k = i;
            }
        return k;
    }

    @Override
    protected double extrapolateLeft(double x) {
        if (this.count == 1) {
            return this.y[0];
        }
        return interpolate(x, 0);
    }

    @Override
    protected double extrapolateRight(double x) {
        if (count == 1) {
            return y[0];
        }
        return interpolate(x, count - 2);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        if (count == 1) {
            return y[0];
        }
        return interpolate(x, this.x[floorIndex], this.x[floorIndex + 1], y[floorIndex], y[floorIndex + 1]);
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public double getX(int index) {
        return this.x[index];
    }

    @Override
    public double getY(int index) {
        return this.y[index];
    }

    @Override
    public void setY(int index, double value) {
        this.y[index] = value;
    }

    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < this.count; i++) {
            if (x == this.x[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < this.count; i++) {
            if (y == this.y[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double leftBound() {
        return this.x[0];
    }

    @Override
    public double rightBound() {
        return this.x[count - 1];
    }
}
