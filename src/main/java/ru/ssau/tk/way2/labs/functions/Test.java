package ru.ssau.tk.way2.labs.functions;

public class Test {
    public static void main(String[] args){
    IdentityFunction first=new IdentityFunction(2.345);
        System.out.println(first.apply(first.x));
    SqrFunction second=new SqrFunction(34.01);
        System.out.println(second.apply(second.x));
    root4Function third=new root4Function(16);
        System.out.println(third.apply(third.x));
    absFunction fourth=new absFunction(-3.5);
        System.out.println(fourth.apply(fourth.x));
    CompositeFunction fifth=new CompositeFunction(new absFunction(-16), new root4Function(16),-16);
        System.out.println(fifth.apply(fifth.x));
    ConstantFunction sixth=new ConstantFunction(2);
        System.out.println(sixth.apply(2));
    ZeroFunction seventh=new ZeroFunction();
        System.out.println(seventh.apply(9));
    UnoFunction eighth=new UnoFunction();
        System.out.println(eighth.apply(578));
    SqrFunction ninth=new SqrFunction(10);
    CompositeFunction tenth=ninth.andThen(new SqrFunction(ninth.apply(10)));
        System.out.println(tenth.apply(15));
    }
}
