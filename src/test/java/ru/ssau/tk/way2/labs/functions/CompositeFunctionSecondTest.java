package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionSecondTest {
    @Test
    public void test() {
        CompositeFunction first = new CompositeFunction(new ArrayTabulatedFunction(new double[]{1, 2}, new double[]{2, 1}), new SqrFunction());
        double actual = first.apply(2);
        double expected = 1;
        assertEquals(actual, expected);

        CompositeFunction second = new CompositeFunction(new ArrayTabulatedFunction(new double[]{1, 2, 5}, new double[]{1, 2, 5}), new LinkedListTabulatedFunction(new double[]{1, 2, 5}, new double[]{1, 2, 5}));
        double actualA = second.apply(2);
        double expectedA = 2;
        assertEquals(actualA, expectedA);
    }
}