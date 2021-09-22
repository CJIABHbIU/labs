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
    }
    @Test
    public void testApply1() {
        SqrFunction first = new SqrFunction();
        double actual = first.apply(-2);
        double expected = 4;
        assertEquals(actual, expected);
    }
    @Test
    public void testApply2() {
        SqrFunction first = new SqrFunction();
        double actual = first.apply(0);
        double expected = 0;
        assertEquals(actual, expected);
    }
}