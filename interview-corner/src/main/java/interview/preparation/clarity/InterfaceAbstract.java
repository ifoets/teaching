package interview.preparation.clarity;

public class InterfaceAbstract {
    public  A getA()
    {
       return new A();
    }
}
 interface Intrf1 {
    public void m1();
}
interface Intrf2 {
    public void m1();
}
 abstract class Abs implements Intrf2 {
    public void m1() {
        System.out.println("Abs.m1()");
    }
}

 class A extends Abs implements Intrf1 {

    @Override
    public void m1() {
        System.out.println("m2()");
    }
}

