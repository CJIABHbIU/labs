package operations;

import ru.ssau.tk.way2.labs.functions.MathFunction;

    public interface DifferentialOperator<T extends MathFunction> {
        T derive(T function);
    }