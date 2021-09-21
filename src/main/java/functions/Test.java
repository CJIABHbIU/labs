package functions;

public class Test {
    public static void main(){
    IdentityFunction first=new IdentityFunction(2.345);
    first.apply(first.x);
    }
}
