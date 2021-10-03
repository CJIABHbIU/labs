package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {

    @Test
    public void testAll() {
        LinkedListTabulatedFunction first = new LinkedListTabulatedFunction(new double[]{1, 3, 100}, new double[]{2, 6, 200});
        int actual = first.floorIndexOfX(50);
        int expected = 1;
        assertEquals(actual, expected);
        System.out.println(first.getY(2));

        double actualA = first.extrapolateLeft(40);
        double expectedA = 80;
        assertEquals(actualA, expectedA);

        double actualB = first.extrapolateRight(40);
        double expectedB = 80;
        assertEquals(actualB, expectedB);

        double actualC = first.interpolate(40, 1);
        double expectedC = 80;
        assertEquals(actualC, expectedC);

        int actualD = first.indexOfX(6);
        int expectedD = -1;
        assertEquals(expectedD, actualD);

        LinkedListTabulatedFunction second = new LinkedListTabulatedFunction(new SqrFunction(), 14, 14, 1);
        assertEquals(second.apply(14), 196);
        assertEquals(second.extrapolateLeft(13), 196);
        assertEquals(first.apply(0), 0);
        assertEquals(first.apply(3), 6);
        assertEquals(first.apply(2), 4);
        assertEquals(first.apply(1000), 2000);
        assertEquals(first.indexOfY(6), 1);
        first.setY(1, 10);
        assertEquals(first.getY(1), 10);

        TabulatedFunction third = new ArrayTabulatedFunction(new SqrFunction(), 10, 20, 6);
        assertEquals(third.apply(0), -120);
        assertEquals(third.apply(14), 196);
        assertEquals(third.apply(15), 226);
        assertEquals(third.apply(21), 438);
    }
}