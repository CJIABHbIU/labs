package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MathFunctionTest {

    @Test
    public void testAndThen() {
        SqrFunction first=new SqrFunction();
        double actual=first.andThen(new FourthRootFunction()).apply(-4);
        double expected=2;
        assertEquals(actual,expected);
        double actualA=first.andThen(new SqrFunction()).andThen(new FourthRootFunction()).apply(-2);
        assertEquals(actualA,expected);
    }
}