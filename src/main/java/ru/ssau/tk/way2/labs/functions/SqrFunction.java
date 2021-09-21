package ru.ssau.tk.way2.labs.functions;

public class SqrFunction implements MathFunction{
    double x;
    public SqrFunction(double x){
        this.x=x;
    }
    @Override
    public double apply(double x){
        return Math.pow(this.x,2);
    }
}
