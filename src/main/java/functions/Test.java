package functions;

public class Test {
    public static void main(String[] args){
    IdentityFunction first=new IdentityFunction(2.345);
        System.out.println(first.apply(first.x));
    }
}
