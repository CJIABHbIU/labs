package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstantFunctionTest {

    @Test
    public void testApply() {
        ConstantFunction first=new ConstantFunction(34);
        double actual=first.apply(689);
        double expected= 34;
        assertEquals(actual,expected);
    }
}