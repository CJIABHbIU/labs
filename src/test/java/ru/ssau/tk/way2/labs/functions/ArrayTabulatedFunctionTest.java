package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionTest {

    @Test
    public void testAll() {
        AbstractTabulatedFunction first = new ArrayTabulatedFunction(new double[]{1, 3, 100}, new double[]{2, 6, 200});
        int actual = first.floorIndexOfX(50);
        int expected = 1;
        assertEquals(actual, expected);

        double actualA = first.extrapolateLeft(2);
        double expectedA = 4;
        assertEquals(actualA, expectedA);

        double actualB = first.extrapolateRight(40);
        double expectedB = 80;
        assertEquals(actualB, expectedB);

        double actualC = first.interpolate(40, 1);
        double expectedC = 80;
        assertEquals(actualC, expectedC);
        assertEquals(first.apply(3), 6);
        assertEquals(first.apply(2), 4);
        assertEquals(first.indexOfY(6), 1);
        first.setY(1, 10);
        assertEquals(first.getY(1), 10);

        TabulatedFunction third = new ArrayTabulatedFunction(new SqrFunction(), 10, 20, 6);
        assertEquals(third.apply(14), 196);
        assertEquals(third.apply(15), 226);
    }
    private final static double DELTA = 0.0001;
    private final double[] valuesX = new double[]{-3., -2., -1, 0., 1., 2., 3., 4., 5.};
    private final double[] valuesY = new double[]{-13., -4., -1., 0., 1., 4., 9., 13., 25.};

    private ArrayTabulatedFunction getDefinedThroughArrays() {
        return new ArrayTabulatedFunction(valuesX, valuesY);
    }

    @Test
    public void testIteratorCycleWhile() {
        Iterator<Point> iterator = getDefinedThroughArrays().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(getDefinedThroughArrays().getX(i), point.x, DELTA);
            assertEquals(getDefinedThroughArrays().getY(i++), point.y, DELTA);
        }
        assertEquals(i, 9);
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testIteratorCycleForEach() {
        int i = 0;
        for (Point point : getDefinedThroughArrays()) {
            assertEquals(getDefinedThroughArrays().getX(i), point.x, DELTA);
            assertEquals(getDefinedThroughArrays().getY(i++), point.y, DELTA);
        }
        assertEquals(i, 9);
    }
}