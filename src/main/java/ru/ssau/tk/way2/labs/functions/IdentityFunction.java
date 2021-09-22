package ru.ssau.tk.way2.labs.functions;

public class IdentityFunction implements MathFunction{                  //класс определяющий ф-ию, испльзующий функционал интерфейса
    double x;
    public IdentityFunction(double x) {                         //конструктор
        this.x=x;
    }

    @Override                                                              //переопределение метода
    public double apply(double x) {
        return this.x;
    }
}
