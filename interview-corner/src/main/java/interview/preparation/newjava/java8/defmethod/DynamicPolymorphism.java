package interview.preparation.newjava.java8.defmethod;

interface Greeting {
    default void sayHi() {
        System.out.println("Hi");
    }
}

class EnglishGreeting implements Greeting {
    public void sayHi() {
        System.out.println("Hello");
    }
}

public class DynamicPolymorphism {
    public static void main(String[] args) {
        Greeting g = new EnglishGreeting();
        g.sayHi(); // Hello — dynamic dispatch!
    }
}
