package operations;

import ru.ssau.tk.way2.labs.functions.MathFunction;
import ru.ssau.tk.way2.labs.functions.TabulatedFunction;

public interface DifferentialOperator<T extends MathFunction> {
        T derive(T function);
}