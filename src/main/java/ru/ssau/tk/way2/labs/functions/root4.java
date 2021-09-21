package ru.ssau.tk.way2.labs.functions;

public class root4 implements MathFunction{
    double x;
    public root4(double x) {
        this.x = x;
    }
    @Override
    public double apply(double x){
        return(Math.sqrt(Math.sqrt(this.x)));
    }
}
