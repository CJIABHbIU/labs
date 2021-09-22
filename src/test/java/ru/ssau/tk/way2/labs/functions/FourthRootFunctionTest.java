package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FourthRootFunctionTest {

    @Test
    public void testApply() {
        FourthRootFunction first = new FourthRootFunction();
        double actual = first.apply(16);
        double expected = 2;
        assertEquals(actual, expected);
        FourthRootFunction second = new FourthRootFunction();
        double actualA = first.apply(-16);
        double expectedA = Double.NaN;
        assertEquals(actualA, expectedA);
        FourthRootFunction third = new FourthRootFunction();
        double actualB = first.apply(0);
        double expectedB = 0;
        assertEquals(actualB, expectedB);
    }
}