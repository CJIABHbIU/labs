package ru.ssau.tk.way2.labs.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.way2.labs.functions.SqrFunction;

import static org.testng.Assert.*;

public class LeftSteppingDifferentialOperatorTest {
    @Test
    public void testDerive() {
        double step = 0.01;
        SteppingDifferentialOperator differentialOperator = new LeftSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(2), 3.9899, 0.0001);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(4), 7.99, 0.0001);
    }
}