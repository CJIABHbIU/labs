package ru.ssau.tk.way2.labs.functions;

import java.util.concurrent.atomic.AtomicReference;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {

    protected static class Node {
        public Node next;
        public Node prev;
        public double x;
        public double y;
    }

    private Node head;
    private Node last;

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
    for (int i=0; i<xValues.length; i++){
        this.addNode(xValues[i],yValues[i]);
    }
    }

    public LinkedListTabulatedFunction(MathFunction source,double xFrom, double xTo, int count) {
        double step=(xTo-xFrom)/(count-1);
        for (int i=0; i<count; i++){
            addNode(xFrom+i*step,source.apply(xFrom+i*step));
        }
    }
    private Node getNode (int index){
        Node getter;
        getter=this.head;
        for (int i=0;i<index; i++ ){
            getter=getter.next;
        }
        return getter;
    }

    private void addNode(double x, double y) {
        Node newnode = new Node();
        newnode.x=x;
        newnode.y=y;
        count++;
        if (head == null) {
            head= newnode;
            newnode.prev=newnode;
            newnode.next=newnode;
        } else {
            last.next=newnode;
            head.prev=newnode;
            newnode.prev=last;
            newnode.next=head;
        }
        last=head.prev;
    }

    @Override
    int floorIndexOfx(double x) {
        int k = 0;
        for(int i=0;i<count;i+=1)
            if (this.getNode(i).x <= x) {
                k = i;
            }
        return k;
    }

    @Override
    double extrapolateLeft(double x) {
        return (this.getNode(0).y + (this.getNode(1).y - this.getNode(0).y) / (this.getNode(1).x - this.getNode(0).x) * (x - this.getNode(0).x));
    }

    @Override
    double extrapolateRight(double x) {
        return (this.getNode(count-1).y + (this.getNode(count).y - this.getNode(count-1).y) / (this.getNode(count).x - this.getNode(count-1).x) * (x - this.getNode(count-1).x));
    }

    @Override
    double interpolate(double x, int floorIndex) {
        return (this.getNode(floorIndex-1).y + (this.getNode(floorIndex).y - this.getNode(floorIndex-1).y) / (this.getNode(floorIndex).x - this.getNode(floorIndex-1).x) * (x - this.getNode(floorIndex-1).x));
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        return this.getNode(index).x;
    }

    @Override
    public double getY(int index) {
        return this.getNode(index).y;
    }

    @Override
    public void setY(int index, double value) {
        this.getNode(index).y=value;
    }

    @Override
    public int indexOfX(double x) {
        int k=-1;
        for(int i=0;i<this.count;i++){
            if(x==this.getNode(i).x){
                k=i;
                break;
            }
        }
        return k;
    }

    @Override
    public int indexOfY(double y) {
        int k=-1;
        for(int i=0;i<this.count;i++){
            if(y==this.getNode(i).y){
                k=i;
                break;
            }
        }
        return k;
    }

    @Override
    public double leftBound() {
        return this.getNode(0).x;
    }

    @Override
    public double rightBound() {
        return this.getNode(count).x;
    }
}
