package interview.preparation.self.basic.prep.mcq;

 class Vehicle {
    public void move() {
        System.out.println("The vehicle moves");
    }

     public static void staticMove() {
         System.out.println("The static vehicle moves");
     }

     private void m1()
     {
         System.out.println("From Vehicle m1()");
     }

     protected void m2()
     {
         System.out.println("From Vehicle m2()");
     }


 }

 class Car extends Vehicle {
    public void move() {
        System.out.println("The car moves");
    }
     public static void staticMove() {
         System.out.println("The static car moves");
     }

     private void m1()
     {
         System.out.println("From Car m1()");
     }

     protected void m2()
     {
         System.out.println("From Car m2()");
     }

 }

class Parent1 {
    String name = "parent";
    String message() {
        return "from parent";
    }

    final void show() { System.out.println("From parent"); }


}

class Child1 extends Parent1 {
    String name = "child";
    String message() {
        return "from child";
    }

    //final method can not overriding
  // public static void show() { System.out.println("From child"); }

}

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        //overriding method get called from child object
        vehicle.move();
        //static not overriding here method hiding take place
        vehicle.staticMove();

        //while methods are overridden (dynamic binding), variables are not overridden (static binding).
        Parent1 p = new Child1();
        System.out.println(p.name + " " + p.message());

        System.out.println();

        //call get from super
        Vehicle v1 = new Vehicle();
        v1.m2();
        //call get from child
        Vehicle v2 = new Car();
        v2.m2();


    }
}