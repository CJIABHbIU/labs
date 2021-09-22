package ru.ssau.tk.way2.labs.functions;

public class CompositeFunction implements MathFunction{
    private MathFunction FirstFunction;
    private MathFunction SecondFunction;
    public CompositeFunction(MathFunction FirstFunction,MathFunction SecondFunction){
        this.FirstFunction=FirstFunction;
        this.SecondFunction=SecondFunction;
    }

    @Override
    public double apply(double x){
        return(SecondFunction.apply(FirstFunction.apply(x)));
    }
}
