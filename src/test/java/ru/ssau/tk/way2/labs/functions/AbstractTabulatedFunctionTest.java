package ru.ssau.tk.way2.labs.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.way2.labs.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.way2.labs.exceptions.DifferentLengthOfArraysException;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {
    @Test
    public void testCheckLengthIsTheSame() {
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            double[] x = new double[]{1, 4, 9, 16};
            double[] y = new double[]{1, 16, 81, 256, 22};
            AbstractTabulatedFunction.checkLengthIsTheSame(x, y);
        });
        double[] x = new double[]{1, 4, 9, 16, 20};
        double[] y = new double[]{1, 16, 81, 256, 22};
        AbstractTabulatedFunction.checkLengthIsTheSame(x, y);
    }
    @Test
    public void testCheckSorted() {
        assertThrows(ArrayIsNotSortedException.class, () -> {
            double[] x = new double[]{1, 4, 33, 9, 16};
            AbstractTabulatedFunction.checkSorted(x);
        });
        double[] x = new double[]{1, 5, 9, 10, 16};
        AbstractTabulatedFunction.checkSorted(x);

    }
}