package ru.ssau.tk.way2.labs.functions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ssau.tk.way2.labs.exceptions.InterpolationException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Serializable, Insertable, Removable {
    private static final long serialVersionUID = -275918781697489264L;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    private double[] x;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    private double[] y;

    @JsonCreator
    public ArrayTabulatedFunction(@JsonProperty(value = "xValue") double[] xValues, @JsonProperty(value = "yValues") double[] yValues) {
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

    @Override
    public void insert(double x, double y) {
        int u;
        int ch = 0;
        boolean flag = false;
        for (u = 0; u < count; u++) {
            if (this.x[u] == x) {
                this.y[u] = y;
                ch = 1;
                break;
            }
        }
        if (ch == 0) {
            double[] yValues1 = new double[count + 1];
            double[] xValues1 = new double[count + 1];
            u = 0;
            if(x<this.x[0]){
                xValues1[0] = x;
                yValues1[0] = y;
                flag = true;
            }
            while (u < count - 1) {
                if (x > this.x[u]) {
                    xValues1[u] = this.x[u];
                    yValues1[u] = this.y[u];
                }
                if((this.x[u] < x) & (x < this.x[u + 1])){
                    xValues1[u+1] = x;
                    yValues1[u+1] = y;
                    flag = true;
                }
                if(flag & x < this.x[u]){
                    xValues1[u+1] = this.x[u];
                    yValues1[u+1] = this.y[u];
                } else if(this.x[u] > x){
                    xValues1[u] = this.x[u];
                    yValues1[u] = this.y[u];
                }
                u++;
            }
            if(flag){
                xValues1[count] = this.x[count - 1];
                yValues1[count] = this.y[count - 1];
            } else if(x < this.x[count - 1]){
                xValues1[count-1] = x;
                yValues1[count-1] = y;
                xValues1[count] = this.x[count - 1];
                yValues1[count] = this.y[count - 1];
            } else{
                xValues1[count] = x;
                yValues1[count] = y;
                xValues1[count - 1] = this.x[count - 1];
                yValues1[count - 1] = this.y[count - 1];
            }
            count++;
            this.y = yValues1;
            this.x = xValues1;
        }
    }

    @Override
    public void remove(int index) {
        if (count <= 2) {
            throw new IllegalArgumentException("Array's length is less than 2");
        }
        double[] xValues1 = new double[count - 1];
        double[] yValues1 = new double[count - 1];
        System.arraycopy(this.y, 0, yValues1, 0, index);
        System.arraycopy(this.y, index + 1, yValues1, index, count - index - 1);

        System.arraycopy(this.x, 0, xValues1, 0, index);
        System.arraycopy(this.x, index + 1, xValues1, index, count - index - 1);
        count--;
        this.x = xValues1;
        this.y = yValues1;
    }
}
