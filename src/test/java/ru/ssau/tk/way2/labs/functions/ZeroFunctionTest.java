package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {

    @Test
    public void testApply() {
        ZeroFunction first = new ZeroFunction();
        double actual = first.apply(-8);
        double expected = 0;
        assertEquals(actual, expected);
    }
}