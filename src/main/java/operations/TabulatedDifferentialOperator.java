package operations;

import ru.ssau.tk.way2.labs.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.way2.labs.functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator {
    TabulatedFunctionFactory factory;

    public TabulatedDifferentialOperator() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }
}
