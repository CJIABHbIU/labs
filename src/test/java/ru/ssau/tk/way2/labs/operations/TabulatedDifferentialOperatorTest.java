package ru.ssau.tk.way2.labs.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.way2.labs.functions.ArrayTabulatedFunction;
import ru.ssau.tk.way2.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.way2.labs.functions.TabulatedFunction;
import ru.ssau.tk.way2.labs.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.way2.labs.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.testng.Assert.*;

public class TabulatedDifferentialOperatorTest {
    public static final double ACCURACY = 0.00001;

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{2, 4, 6, 8, 10};

    @Test
    public void testDerive() {
        TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValues, yValues);
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction diffFunctionList = differentialOperator.derive(linkedListTabulatedFunction);

        assertEquals(diffFunctionList.getX(0), 1, ACCURACY);
        assertEquals(diffFunctionList.getX(4), 5, ACCURACY);
        assertEquals(diffFunctionList.getY(0), 2, ACCURACY);
        assertEquals(diffFunctionList.getY(4), 2, ACCURACY);
        assertTrue(diffFunctionList instanceof LinkedListTabulatedFunction);

        TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValues, yValues);
        TabulatedDifferentialOperator differentialOperator1 = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
        TabulatedFunction diffFunctionArray = differentialOperator1.derive(arrayTabulatedFunction);

        assertEquals(diffFunctionArray.getX(0), 1, ACCURACY);
        assertEquals(diffFunctionArray.getX(4), 5, ACCURACY);
        assertEquals(diffFunctionArray.getY(0), 2, ACCURACY);
        assertEquals(diffFunctionArray.getY(4), 2, ACCURACY);
        assertTrue(diffFunctionArray instanceof ArrayTabulatedFunction);
    }

    @Test
    public void testDeriveSynchronously() {
        TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValues, yValues);
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction diffFunctionList = differentialOperator.deriveSynchronously(linkedListTabulatedFunction);
        TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValues, yValues);
        TabulatedDifferentialOperator differentialOperator1 = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
        TabulatedFunction diffFunctionArray = differentialOperator1.deriveSynchronously(arrayTabulatedFunction);

        assertEquals(diffFunctionList.getX(0), 1, ACCURACY);
        assertEquals(diffFunctionList.getX(4), 5, ACCURACY);
        assertEquals(diffFunctionList.getY(0), 2, ACCURACY);
        assertEquals(diffFunctionList.getY(4), 2, ACCURACY);

        assertEquals(diffFunctionArray.getX(0), 1, ACCURACY);
        assertEquals(diffFunctionArray.getX(4), 5, ACCURACY);
        assertEquals(diffFunctionArray.getY(0), 2, ACCURACY);
        assertEquals(diffFunctionArray.getY(4), 2, ACCURACY);
    }
}