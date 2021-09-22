package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {

    @Test
    public void testApply() {
        CompositeFunction first = new CompositeFunction(new SqrFunction(), new SqrFunction());
        double actual = first.apply(-8);
        double expected = 4096;
        assertEquals(actual, expected);
        CompositeFunction second = new CompositeFunction(new FourthRootFunction(), new SqrFunction());
        double actualA = second.apply(16);
        double expectedA = 4;
        assertEquals(actualA, expectedA);
    }
}