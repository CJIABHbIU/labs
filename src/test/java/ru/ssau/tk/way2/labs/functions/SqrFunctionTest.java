package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrFunctionTest {

    @Test
    public void testApply() {
        SqrFunction first = new SqrFunction();
        double actual = first.apply(2);
        double expected = 4;
        assertEquals(actual, expected);
        SqrFunction second = new SqrFunction();
        double actualA = second.apply(-2);
        double expectedA = 4;
        assertEquals(actualA, expectedA);
        SqrFunction third = new SqrFunction();
        double actualB = third.apply(0);
        double expectedB = 0;
        assertEquals(actualB, expectedB);
    }
}