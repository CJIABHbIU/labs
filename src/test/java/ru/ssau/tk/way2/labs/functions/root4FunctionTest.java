package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class root4FunctionTest {

    @Test
    public void testApply() {
        root4Function first = new root4Function();
        double actual = first.apply(16);
        double expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void testApply2() {
        root4Function first = new root4Function();
        double actual = first.apply(-16);
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testApply3() {
        root4Function first = new root4Function();
        double actual = first.apply(0);
        double expected = 0;
        assertEquals(actual, expected);
    }
}