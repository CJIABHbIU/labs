package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {

    @Test
    public void testAll() {
        LinkedListTabulatedFunction first=new LinkedListTabulatedFunction(new double[]{1, 3, 100}, new double[]{2, 6, 200});
        int actual=first.floorIndexOfx(50);
        int expected=1;
        assertEquals(actual,expected);

        double actualA=first.extrapolateLeft(40);
        double expectedA=80;
        assertEquals(actualA,expectedA);

        double actualB=first.extrapolateRight(40);
        double expectedB=80;
        assertEquals(actualB,expectedB);

        double actualC=first.interpolate(40,2);
        double expectedC=80;
        assertEquals(actualC,expectedC);

        int actualD=first.indexOfX(6);
        int expectedD=-1;
        //assertEquals(expectedD,actualD);
    }
}