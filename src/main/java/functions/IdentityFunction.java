package functions;

public class IdentityFunction implements MathFunction{
    double x;
    public IdentityFunction(double x) {
        this.x=x;
    }

    @Override
    public double apply(double x) {
        return this.x;
    }
}
