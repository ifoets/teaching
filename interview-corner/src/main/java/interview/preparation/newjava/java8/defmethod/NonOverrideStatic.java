package interview.preparation.newjava.java8.defmethod;

interface NonOverrideStaticInterface {
    static void sayHello() {
        System.out.println("Hello");
    }
}

interface OverrideDefaultInterface {
    default void sayHello() {
        System.out.println("Hello from default method");
    }
}

public class NonOverrideStatic implements NonOverrideStaticInterface, OverrideDefaultInterface {

    public void sayHello() {
        System.out.println("Hello from implemented method");
    }

    public static void main(String[] args) {
        //NonOverrideStatic.sayHello(); // ❌ Error
        NonOverrideStaticInterface.sayHello(); // ✅ Correct way

        new NonOverrideStatic().sayHello();
    }
}

