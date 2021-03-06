package ru.ssau.tk.way2.labs.io;

import ru.ssau.tk.way2.labs.functions.ArrayTabulatedFunction;
import ru.ssau.tk.way2.labs.functions.TabulatedFunction;

import java.io.*;

public class ArrayTabulatedFunctionSerializationJson {
    public static void main(String[] args) {
        File fileArray = new File("output/serialized array functions JSON.txt");

        double[] xValue = new double[]{1, 2, 3, 4, 5};
        double[] yValue = new double[]{2, 4, 6, 8, 10};

        ArrayTabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValue, yValue);

        try(BufferedWriter out = new BufferedWriter(new FileWriter(fileArray))){
            FunctionsIO.serializeJson(out, arrayFunction);
        } catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader in = new BufferedReader(new FileReader(fileArray))){
            TabulatedFunction function = FunctionsIO.deserializeJson(in);
            System.out.println(function.toString());
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
