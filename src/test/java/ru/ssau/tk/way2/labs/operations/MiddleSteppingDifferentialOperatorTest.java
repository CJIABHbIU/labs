package ru.ssau.tk.way2.labs.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.way2.labs.functions.SqrFunction;

import static org.testng.Assert.*;

public class MiddleSteppingDifferentialOperatorTest {
    @Test
    public void testDerive() {
        double step = 0.001;
        SteppingDifferentialOperator differentialOperator = new MiddleSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(0), 0, 0.0001);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(1), 2, 0.0001);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(2), 4, 0.0001);
    }
}