package ru.ssau.tk.way2.labs.concurrent;

import ru.ssau.tk.way2.labs.functions.TabulatedFunction;

public class MultiplyingTask implements Runnable {

    private final TabulatedFunction function;
    private Runnable postRunAction;

    public MultiplyingTask(TabulatedFunction function) {
        this.function = function;
    }

    public MultiplyingTask(TabulatedFunction function, Runnable postRunAction) {
        this.function = function;
        this.postRunAction = postRunAction;
    }

    @Override
    public void run() {
        double x;
        double y;
        for (int i = 0; i < function.getCount(); i++) {
            x = function.getX(i);
            synchronized (function) {
                y = function.getY(i);
                System.out.printf("%s, i = %d, x = %f, old y = %f \n", Thread.currentThread().getName(), i, x, y);
                function.setY(i, y * 10);
                y = function.getY(i);
                System.out.printf("%s, i = %d, x = %f, new y = %f \n", Thread.currentThread().getName(), i, x, y);
            }
        }
        postRunAction.run();
    }
}
