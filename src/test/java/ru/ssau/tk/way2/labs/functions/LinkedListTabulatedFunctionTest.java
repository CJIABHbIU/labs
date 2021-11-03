package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.way2.labs.exceptions.InterpolationException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {

    public static final double ACCURACY = 0.00001;

    private final MathFunction function = new SqrFunction();

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{2, 4, 6, 8, 10};

    private LinkedListTabulatedFunction getListOfMathFunc1() {
        return new LinkedListTabulatedFunction(function, 1, 5, 10);
    }

    private LinkedListTabulatedFunction getListOfMathFunc2() {
        return new LinkedListTabulatedFunction(function, -3, 3, 20);
    }

    private LinkedListTabulatedFunction getListOfMathFunc3() {
        return new LinkedListTabulatedFunction(function, 10, 20, 50);
    }

    private LinkedListTabulatedFunction getListOfArray() {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    @Test
    public void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(new double[]{1}, new double[]{2});
        });

        LinkedListTabulatedFunction list1 = new LinkedListTabulatedFunction(new double[]{1, 3}, new double[]{2, 4});

        assertThrows(IllegalArgumentException.class, () -> {
            LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(function, 3, 1, 10);
        });

        LinkedListTabulatedFunction list2 = new LinkedListTabulatedFunction(function, 1, 3, 10);

    }

    @Test
    public void testAddNode() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        listOfArray.addNode(9, 99);
        assertEquals(listOfArray.rightBound(), 9, ACCURACY);
    }

    @Test
    public void testGetCount() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        LinkedListTabulatedFunction listOfMathFunc1 = getListOfMathFunc1();
        LinkedListTabulatedFunction listOfMathFunc2 = getListOfMathFunc2();
        LinkedListTabulatedFunction listOfMathFunc3 = getListOfMathFunc3();

        assertEquals(listOfArray.getCount(), 5);
        assertEquals(listOfMathFunc1.getCount(), 10);
        assertEquals(listOfMathFunc2.getCount(), 20);
        assertEquals(listOfMathFunc3.getCount(), 50);
    }

    @Test
    public void testLeftBound() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        LinkedListTabulatedFunction listOfMathFunc1 = getListOfMathFunc1();
        LinkedListTabulatedFunction listOfMathFunc2 = getListOfMathFunc2();
        LinkedListTabulatedFunction listOfMathFunc3 = getListOfMathFunc3();

        assertEquals(listOfMathFunc1.leftBound(), 1.0);
        assertEquals(listOfMathFunc2.leftBound(), -3.0);
        assertEquals(listOfMathFunc3.leftBound(), 10.0);
        assertEquals(listOfArray.leftBound(), 1.0);
    }

    @Test
    public void testRightBound() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        LinkedListTabulatedFunction listOfMathFunc1 = getListOfMathFunc1();
        LinkedListTabulatedFunction listOfMathFunc2 = getListOfMathFunc2();
        LinkedListTabulatedFunction listOfMathFunc3 = getListOfMathFunc3();

        assertEquals(listOfArray.rightBound(), 5.0);

        assertEquals(listOfMathFunc1.rightBound(), 5.0, ACCURACY);
        assertEquals(listOfMathFunc2.rightBound(), 3.0, ACCURACY);
        assertEquals(listOfMathFunc3.rightBound(), 20.0, ACCURACY);
    }

    @Test
    public void testGetNode() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();

        assertEquals(listOfArray.getNode(2).x, 3, ACCURACY);
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getNode(100));
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getNode(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getNode(5));

    }

    @Test
    public void testGetX() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        LinkedListTabulatedFunction listOfMathFunc1 = getListOfMathFunc1();
        LinkedListTabulatedFunction listOfMathFunc2 = getListOfMathFunc2();
        LinkedListTabulatedFunction listOfMathFunc3 = getListOfMathFunc3();

        assertEquals(listOfMathFunc1.getX(0), 1.0);
        assertEquals(listOfMathFunc1.getX(9), 5.0, ACCURACY);
        assertEquals(listOfMathFunc2.getX(0), -3.0);
        assertEquals(listOfMathFunc3.getX(0), 10.0);

        assertEquals(listOfArray.getX(0), 1.0);
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().getX(100));
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().getX(5));
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().getX(-1));
    }

    @Test
    public void testGetY() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        LinkedListTabulatedFunction listOfMathFunc1 = getListOfMathFunc1();
        LinkedListTabulatedFunction listOfMathFunc2 = getListOfMathFunc2();
        LinkedListTabulatedFunction listOfMathFunc3 = getListOfMathFunc3();

        assertEquals(listOfArray.getY(0), 2, ACCURACY);
        assertEquals(listOfMathFunc1.getY(0), 1, ACCURACY);
        assertEquals(listOfMathFunc2.getY(0), 9, ACCURACY);
        assertEquals(listOfMathFunc3.getY(0), 100, ACCURACY);

        assertThrows(IllegalArgumentException.class, () -> getListOfArray().getY(100));
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().getY(-1));
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().getY(5));

    }

    @Test
    public void testSetY() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();

        listOfArray.setY(2, 39);
        assertEquals(listOfArray.getY(2), 39, ACCURACY);

        assertThrows(IllegalArgumentException.class, () -> getListOfArray().setY(100, 1));
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().setY(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().setY(5, 1));
    }

    @Test
    public void testIndexOfX() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        LinkedListTabulatedFunction listOfMathFunc1 = getListOfMathFunc1();

        assertEquals(listOfArray.indexOfX(4), 3);
        assertEquals(listOfMathFunc1.indexOfX(3), -1);
        assertEquals(listOfMathFunc1.indexOfX(100), -1);
    }

    @Test
    public void testIndexOfY() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();

        assertEquals(listOfArray.indexOfY(4), 1);
        assertEquals(listOfArray.indexOfY(6), 2);
        assertEquals(listOfArray.indexOfY(8), 3);
    }

    @Test
    public void testFloorIndexOfX() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        LinkedListTabulatedFunction listOfMathFunc1 = getListOfMathFunc1();

        assertEquals(listOfArray.floorIndexOfX(1.1), 0);
        assertEquals(listOfArray.floorIndexOfX(3.2), 2);
        assertEquals(listOfMathFunc1.floorIndexOfX(1.1), 0);
        assertEquals(listOfMathFunc1.floorIndexOfX(100), 9);

        assertThrows(IllegalArgumentException.class, () -> getListOfArray().floorIndexOfX(-1));
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().floorIndexOfX(0));

    }

    @Test
    public void testInterpolate() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();

        assertEquals(listOfArray.interpolate(4, 3), 8.0);
        assertEquals(listOfArray.interpolate(3, 2), 6.0);
        assertThrows(InterpolationException.class, () -> listOfArray.interpolate(15, 2));
        assertThrows(InterpolationException.class, () -> listOfArray.interpolate(9, 1));
    }

    @Test
    public void testIteratorFirst() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        Iterator<Point> iterator = listOfArray.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(listOfArray.getX(i++), point.x, ACCURACY);
        }
        assertEquals(listOfArray.getCount(), i);

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testIteratorSecond() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();
        int i = 0;
        for (Point point : listOfArray) {
            assertEquals(listOfArray.getX(i++), point.x, ACCURACY);
        }
        assertEquals(listOfArray.getCount(), i);

    }
}