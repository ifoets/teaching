package interview.preparation.newjava.java8.defmethod;

/*The method from the abstract (super) class overrides the default method in the interface.
This is because the class hierarchy has higher priority than the interface hierarchy.
*/

interface IAbsI {
    default void show() {
        System.out.println("Interface show()");
    }
}

abstract class AAbsI {
    public void show() {
        System.out.println("Abstract class show()");
    }
}

class BAbsI extends AAbsI implements IAbsI {
    // no override of show()
}

public class AbstractInterfaceRace {
    public static void main(String[] args) {
        BAbsI obj = new BAbsI();
        obj.show();  // Output? from abstract
    }
}
