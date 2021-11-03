package ru.ssau.tk.way2.labs.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.way2.labs.functions.SqrFunction;

import static org.testng.Assert.*;

public class RightSteppingDifferentialOperatorTest {
    @Test
    public void testDerive() {
        double step = 0.005;
        SteppingDifferentialOperator differentialOperator = new RightSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(0), 0.005, 0.0001);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(1), 2.005, 0.0001);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(2), 4.005, 0.0001);
    }
}