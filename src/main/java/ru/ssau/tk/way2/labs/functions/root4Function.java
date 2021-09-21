package ru.ssau.tk.way2.labs.functions;

public class root4Function implements MathFunction{
    double x;
    public root4Function(double x) {
        this.x = x;
    }
    @Override
    public double apply(double x){
        return(Math.sqrt(Math.sqrt(this.x)));
    }
}
