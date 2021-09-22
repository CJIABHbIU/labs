package ru.ssau.tk.way2.labs.functions;

public class Test {
    public static void main(String[] args){
    IdentityFunction first=new IdentityFunction();
        System.out.println(first.apply(100));
    SqrFunction second=new SqrFunction();
        System.out.println(second.apply(12.34));
    root4Function third=new root4Function();
        System.out.println(third.apply(135.39));
    absFunction fourth=new absFunction();
        System.out.println(fourth.apply(-34));
    CompositeFunction fifth=new CompositeFunction(new absFunction(), new root4Function());
        System.out.println(fifth.apply(-16));
    ConstantFunction sixth=new ConstantFunction(2);
        System.out.println(sixth.apply(2));
    ZeroFunction seventh=new ZeroFunction();
        System.out.println(seventh.apply(9));
    UnoFunction eighth=new UnoFunction();
        System.out.println(eighth.apply(578));
    SqrFunction ninth=new SqrFunction();
    CompositeFunction tenth=ninth.andThen(new SqrFunction());
        System.out.println(tenth.apply(15));
    }
}
