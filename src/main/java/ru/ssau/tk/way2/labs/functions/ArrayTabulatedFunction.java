package ru.ssau.tk.way2.labs.functions;

import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction {
    private double[] x;
    private double[] y;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        this.x = Arrays.copyOf(xValues, xValues.length);
        this.y = Arrays.copyOf(yValues, xValues.length);
        this.count=xValues.length;
    }

    public ArrayTabulatedFunction(MathFunction source,double xFrom, double xTo, int count) {
        double step=(xTo-xFrom)/(count-1);
        for(int i=0;i<count;i++){
            this.x[i]=xFrom+i*step;
            this.y[i]=source.apply(xFrom+i*step);
        }
        this.count=count;
    }
    @Override
    int floorIndexOfx(double x) {
        int k = 0;
        for(int i=0;i<this.count;i+=1)
            if (this.x[i] <= x) {
                k = i;
            }
        return k;
    }

    @Override
    double extrapolateLeft(double x) {
        return (this.y[0] + (this.y[1] - this.y[0]) / (this.x[1] - this.x[0]) * (x - this.x[0]));
    }

    @Override
    double extrapolateRight(double x) {
        return (this.y[this.count-2] + (this.y[this.count-1] - this.y[this.count-2]) / (this.x[this.count-1] - this.x[this.count-2]) * (x - this.x[this.count-2]));
    }

    @Override
    double interpolate(double x, int floorIndex) {
        return (this.y[floorIndex-2] + (this.y[floorIndex-1] - this.y[floorIndex-2]) / (this.x[floorIndex-1] - this.x[floorIndex-2]) * (x - this.x[floorIndex-2]));
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
    this.y[index]=value;
    }

    @Override
    public int indexOfX(double x) {
        int k=-1;
    for(int i=0;i<this.count;i++){
        if(x==this.x[i]){
            k=i;
            break;
        }
    }
    return k;
    }

    @Override
    public int indexOfY(double y) {
        int k=-1;
        for(int i=0;i<this.count;i++){
            if(y==this.y[i]){
                k=i;
                break;
            }
        }
        return k;
    }

    @Override
    public double leftBound() {
        return this.x[0];
    }

    @Override
    public double rightBound() {
        return this.x[count-1];
    }
}
