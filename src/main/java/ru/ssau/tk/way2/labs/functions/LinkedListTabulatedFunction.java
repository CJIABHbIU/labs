package ru.ssau.tk.way2.labs.functions;

import ru.ssau.tk.way2.labs.exceptions.InterpolationException;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction implements Serializable, Insertable, Removable {

    private static final long serialVersionUID = 3822831438809733597L;
    private Node head;

    @Override
    public void insert(double x, double y) {
        if (indexOfX(x) != -1) {
            setY(indexOfX(x), y);
            return;
        }

        if (head == null) {
            addNode(x, y);
            count++;
        } else {
            Node node = new Node();
            node.x = x;
            node.y = y;

            if (head.prev.x < x) {
                node.next = head;
                node.prev = head.prev;
                head.prev.next = node;
                head.prev = node;
            } else if (head.x > x) {
                head.next.prev = head;
                node.next = head;
                node.prev = head.prev;
                head.prev.next = node;
                head = node;
            } else if (floorIndexOfX(x) == count) {
                node.next = head;
                node.prev = head.prev;
                head.prev = node;
                head.prev.next = node;
                head.prev.prev = node;

            } else {
                int ind = floorIndexOfX(x);
                Node check = getNode(ind);
                node.next = check.next;
                node.prev = check;
                check.next = node;
            }
            count++;
        }
    }

    @Override
    public void remove(int index) {
        if (count <= 2) {
            throw new IllegalArgumentException("Length less than or equal to 2 points");
        }

        if (index == 0) {
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next;
        } else {
            Node delete = getNode(index);
            Node prevDelete = getNode(index - 1);
            prevDelete.next = delete.next;
            delete.next.prev = prevDelete;
        }
        count--;
    }

    public static class Node implements Serializable {
        private static final long serialVersionUID = 8650390027478213004L;
        public Node next;
        public Node prev;
        public double x;
        public double y;
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length < 2 || yValues.length < 2) {
            throw new IllegalArgumentException("Size of list is less than minimum (2)");
        }
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count < 2) {
            throw new IllegalArgumentException("Size of list is less than minimum (2)");
        }
        if (xFrom >= xTo) {
            throw new IllegalArgumentException("Max X is less, than min X");
        }
        double step = (xTo - xFrom) / (count - 1);
        for (int i = 0; i < count; i++) {
            addNode(xFrom + i * step, source.apply(xFrom + i * step));
        }
    }

    protected Node getNode(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        Node current;
        current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    protected void addNode(double x, double y) {
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
        count++;
        if (head == null) {
            head = newNode;
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
        if (x < head.x) {
            throw new IllegalArgumentException("X is less than minimal value in linked list");
        }
        int k = 0;
        for (int i = 0; i < count; i += 1)
            if (this.getNode(i).x <= x) {
                k = i;
            }
        return k;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, 0);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, count - 2);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        if (x < leftBound() || rightBound() < x) {
            throw new InterpolationException("X is out of bounds of interpolation");
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
        return getNode(count - 1).x;
    }

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            private Node node = head;

            public boolean hasNext() {
                return (node != null);
            }

            public Point next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Point point = new Point(node.x, node.y);
                node = (node != head.prev) ? node.next : null;
                return point;
            }
        };
    }

    protected Node floorNodeOfX(double x) {
        Node node = head;
        if (x < head.x) {
            throw new IllegalArgumentException("X is less than the left border");
        }
        for (int i = 0; i < count; i++) {
            if (x == head.prev.x) {
                return head.prev;
            } else {
                if (node.x <= x) {
                    node = node.next;
                } else {
                    return node.prev;
                }
            }
        }
        return head.prev;
    }
}
