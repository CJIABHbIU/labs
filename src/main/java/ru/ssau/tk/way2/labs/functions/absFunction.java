package ru.ssau.tk.way2.labs.functions;

public class absFunction implements MathFunction{
    double x;
    public absFunction(double x){
        this.x=x;
    }
    @Override
    public double apply(double x){
        return Math.abs(this.x);
    }
}
