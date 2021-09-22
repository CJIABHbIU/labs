package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbsFunctionTest {

    @Test
    public void testApply() {
        AbsFunction first=new AbsFunction();
        double actual = first.apply(-8);
        double expected= 8;
        assertEquals(actual,expected);
    }
}