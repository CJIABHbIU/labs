package ru.ssau.tk.way2.labs.io;

import ru.ssau.tk.way2.labs.functions.TabulatedFunction;
import ru.ssau.tk.way2.labs.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.way2.labs.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        File file = new File("input/function.txt");
        try (BufferedReader inArray = new BufferedReader(new FileReader(file)); BufferedReader inList = new BufferedReader(new FileReader(file))) {

            TabulatedFunction arrayFunction = FunctionsIO.readTabulatedFunction(inArray, new ArrayTabulatedFunctionFactory());
            System.out.println(arrayFunction.toString());

            TabulatedFunction listFunction = FunctionsIO.readTabulatedFunction(inList, new LinkedListTabulatedFunctionFactory());
            System.out.println(listFunction.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
