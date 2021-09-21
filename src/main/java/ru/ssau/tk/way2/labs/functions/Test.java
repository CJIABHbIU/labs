package ru.ssau.tk.way2.labs.functions;

public class Test {
    public static void main(String[] args){
    IdentityFunction first=new IdentityFunction(2.345);
        System.out.println(first.apply(first.x));
    SqrFunction second=new SqrFunction(34.01);
        System.out.println(second.apply(second.x));
    root4 third=new root4(16);
        System.out.println(third.apply(third.x));
    absFunction fourth=new absFunction(-3.5);
        System.out.println(fourth.apply(fourth.x));
    }
}
