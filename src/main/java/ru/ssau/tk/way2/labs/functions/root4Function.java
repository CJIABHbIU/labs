package ru.ssau.tk.way2.labs.functions;

public class root4Function implements MathFunction{
    @Override
    public double apply(double x){
        return(Math.sqrt(Math.sqrt(x)));
    }
}
