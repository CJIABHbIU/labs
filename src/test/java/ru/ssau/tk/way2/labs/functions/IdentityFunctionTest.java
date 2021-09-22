package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdentityFunctionTest {

    @Test
    public void testApply() {
        IdentityFunction first = new IdentityFunction();
        double actual = first.apply(-8);
        double expected = -8;
        assertEquals(actual, expected);
    }
}