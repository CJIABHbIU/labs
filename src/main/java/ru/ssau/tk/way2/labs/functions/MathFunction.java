package ru.ssau.tk.way2.labs.functions;

public interface MathFunction {                                        //интерфейс
    double apply(double x);
    default CompositeFunction andThen(MathFunction afterFunction){         //метод ревлизующийся в интерфейсее
        return new CompositeFunction(this, afterFunction , 0);
    }
}
