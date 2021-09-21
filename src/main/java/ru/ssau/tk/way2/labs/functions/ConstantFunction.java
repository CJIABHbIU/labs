package ru.ssau.tk.way2.labs.functions;

public class ConstantFunction implements MathFunction{
    private final double MyScore=300;
    public ConstantFunction(double MyScore){
    }
    @Override
    public double apply(double x){
        return MyScore*2;
    }
}

class ZeroFunction implements MathFunction{
    private final double a=0;
    public ZeroFunction(){
    }
    @Override
    public double apply(double x){
        return a;
    }
}

class UnoFunction implements MathFunction{
    private final double b=1;
    public UnoFunction(){
    }
    @Override
    public double apply(double x){
        return b;
    }
}