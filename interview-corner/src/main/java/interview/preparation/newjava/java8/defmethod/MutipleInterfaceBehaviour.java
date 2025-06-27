package interview.preparation.newjava.java8.defmethod;

interface MulA {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface MulB {
    default void hello() {
        System.out.println("Hello from B");
    }
}

class MulC implements MulA, MulB {
    public void hello() {
        MulA.super.hello(); // Resolving conflict manually
    }
}

public class MutipleInterfaceBehaviour {

    public static void main(String[] args) {
        new MulC().hello();
    }
}
