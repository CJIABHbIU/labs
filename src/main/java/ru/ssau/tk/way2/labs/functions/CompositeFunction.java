package ru.ssau.tk.way2.labs.functions;

public class CompositeFunction implements MathFunction{             //класс совмещает несколько ф-ий
    public double x;
    private MathFunction FirstFunction;
    private MathFunction SecondFunction;
    public CompositeFunction(MathFunction FirstFunction,MathFunction SecondFunction, double x){
        this.x=x;
        this.FirstFunction=FirstFunction;
        this.SecondFunction=SecondFunction;
    }

    @Override
    public double apply(double x){
        return(SecondFunction.apply(FirstFunction.apply(this.x)));
    }
}
