package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {

    @Test
    public void testApply() {
        CompositeFunction first = new CompositeFunction(new SqrFunction(), new IdentityFunction());
        double actual = first.apply(-8);
        double expected = 64;
        assertEquals(actual, expected);
    }

    @Test
    public void testApply2() {
        CompositeFunction first = new CompositeFunction(new SqrFunction(), new SqrFunction());
        double actual = first.apply(-8);
        double expected = 4096;
        assertEquals(actual, expected);
    }

    @Test
    public void testApply3() {
        CompositeFunction first = new CompositeFunction(new CompositeFunction(new root4Function(), new SqrFunction()), new IdentityFunction());
        double actual = first.apply(16);
        double expected = 4;
        assertEquals(actual, expected);
    }
}