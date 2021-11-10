package ru.ssau.tk.way2.labs.functions;

import ru.ssau.tk.way2.labs.exceptions.InterpolationException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Serializable {
    private static final long serialVersionUID = -275918781697489264L;
    private final double[] x;
    private final double[] y;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length < 2 || yValues.length < 2) {
            throw new IllegalArgumentException("Size of list is less than minimum (2)");
        }
        checkLengthIsTheSame(xValues, yValues);
        checkSorted(xValues);
        this.x = Arrays.copyOf(xValues, xValues.length);
        this.y = Arrays.copyOf(yValues, xValues.length);
        this.count = xValues.length;
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count < 2) {
            throw new IllegalArgumentException("Size of list is less than minimum (2)");
        }
        if (xFrom >= xTo) {
            throw new IllegalArgumentException("Max X is less, than min X");
        }
        this.count = count;
        double step = (xTo - xFrom) / (count - 1);
        double[] x = new double[count];
        double[] y = new double[count];
        for (int i = 0; i < count; i++) {
            x[i] = xFrom + i * step;
            y[i] = source.apply(xFrom + i * step);
        }
        this.x = Arrays.copyOf(x, count);
        this.y = Arrays.copyOf(y, count);
    }

    @Override
    protected int floorIndexOfX(double x) {
        if (x < this.x[0]) {
            throw new IllegalArgumentException("X is less than the left border of tabulated function");
        }
        int k = 0;
        for (int i = 0; i < this.count; i += 1)
            if (this.x[i] <= x) {
                k = i;
            }
        return k;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, 0);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, count - 2);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        if (x < this.x[floorIndex] || this.x[floorIndex + 1] < x) {
            throw new InterpolationException("X is out of bounds of interpolation");
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
    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < count;
            }

            @Override
            public Point next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Point point = new Point(x[i], y[i]);
                i++;
                return point;
            }
        };
    }
}
