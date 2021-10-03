package ru.ssau.tk.way2.labs.functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {

    private Node head;

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count == 1) {
            addNode(xFrom, source.apply(xFrom));
            return;
        }
        double step = (xTo - xFrom) / (count - 1);
        for (int i = 0; i < count; i++) {
            addNode(xFrom + i * step, source.apply(xFrom + i * step));
        }
    }

    private Node getNode(int index) {
        Node current;
        current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void addNode(double x, double y) {
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
        count++;
        if (head == null) {
            head = newNode;
            head.prev = newNode;
            head.next = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            head.prev.next = newNode;
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = head.prev;
        }
    }

    @Override
    protected int floorIndexOfX(double x) {
        int k = 0;
        for (int i = 0; i < count; i += 1)
            if (this.getNode(i).x <= x) {
                k = i;
            }
        return k;
    }

    @Override
    protected double extrapolateLeft(double x) {
        if (this.count == 1) {
            return getNode(0).y;
        }
        return interpolate(x, 0);
    }

    @Override
    protected double extrapolateRight(double x) {
        if (count == 1) {
            return getNode(0).y;
        }
        return interpolate(x, count - 1);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        if (count == 1) {
            return getNode(0).y;
        }
        return interpolate(x, getNode(floorIndex).x, getNode(floorIndex + 1).x, getNode(floorIndex).y, getNode(floorIndex + 1).y);
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        return getNode(index).x;
    }

    @Override
    public double getY(int index) {
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double value) {
        getNode(index).y = value;
    }

    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < this.count; i++) {
            if (x == getNode(i).x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < this.count; i++) {
            if (y == getNode(i).y) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double leftBound() {
        return getNode(0).x;
    }

    @Override
    public double rightBound() {
        return getNode(count).x;
    }
}
