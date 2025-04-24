package interview.preparation.self.basic.prep.mcq;

public class DimaondProblem {

    class A {
        void doSomething() {
            System.out.println("A is doing something");
        }
    }

    class B extends A {
        void doSomethingElse() {
            System.out.println("B is doing something else");
        }
    }

    class C extends A {
        void doAnotherThing() {
            System.out.println("C is doing another thing");
        }
    }
/*
    static class D extends B, C {  // Error: Class cannot extend multiple classes
        @Override
        void doSomething() {
            System.out.println("D is doing something");
        }

        @Override
        void doSomethingElse() {
            System.out.println("D is doing something else");
        }

        @Override
        void doAnotherThing() {
            System.out.println("D is doing another thing");
        }
    }
        public void main(String[] args) {
            D d = new D();
            d.doSomething();  // Will cause ambiguity if no explicit override is provided
            d.doSomethingElse();
            d.doAnotherThing();
        }

    public static void main(String[] args) {
        D d = new D();
        d.doSomething();  // Will cause ambiguity if no explicit override is provided
        d.doSomethingElse();
        d.doAnotherThing();
    }*/
}
