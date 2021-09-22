package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnoFunctionTest {

    @Test
    public void testApply() {
        UnoFunction first = new UnoFunction();
        double actual = first.apply(-8);
        double expected = 1;
        assertEquals(actual, expected);
    }
}