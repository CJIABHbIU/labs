package ru.ssau.tk.way2.labs.functions;

public abstract class AbstractTabulatedFunction implements TabulatedFunction{
    protected int count;
    abstract int floorIndexOfx(double x);
    abstract double extrapolateLeft(double x);
    abstract double extrapolateRight(double x);
    abstract double interpolate(double x,int floorIndex);
    double interpolate(double x, double leftX, double rightX,double leftY, double rightY) {
        return (leftY + (rightY - leftY) / (rightX - leftX) * (x - leftX));
    }

    double ret=0;
    @Override
    public double apply(double x){
        if (x<leftBound()){
            ret=extrapolateLeft(x);
        }
        if (x>rightBound()){
            ret=extrapolateRight(x);
        }
        if (x>=leftBound()&&x<=rightBound()){
            if(indexOfX(x)==-1){
                ret=interpolate(x,floorIndexOfx(x));
            }
            else {
                ret=getY(indexOfX(x));
            }
        }
        return ret;
    }
}
