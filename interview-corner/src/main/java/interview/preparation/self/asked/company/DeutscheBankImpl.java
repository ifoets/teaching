package interview.preparation.self.asked.company;

import interview.preparation.self.asked.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class DeutscheBankImpl implements IDeutscheBank{

    @Override
    public void producerConsumer() {
        new ProdCons().prodConsRunning();
    }

    @Override
    public void diamondProblem() {
    //@see class D at bottom
    }
    List<String> empName = new ArrayList<>();
    @Override
    public List<String> getEmpListOfManager(List<Employee> list,  String mgrName) {
        return null;
    }
}

    class ProdCons implements  Runnable {
        ProdCons prodCons = new ProdCons();
        public int count=0;
        List<Integer> list = new ArrayList<>();
        public void prodConsRunning() {
            Thread t1 = new Thread(prodCons, "prod");
            Thread t2 = new Thread(prodCons, "cons");
            t1.start();
            t2.start();
        }
        @Override
        public void run() {
            if (count < 15) {
                try {
                    String name = Thread.currentThread().getName();
                    if (name.equals("prod")) {
                        synchronized (this) {
                            while (!list.isEmpty()) {
                                wait(1000);
                            }
                            System.out.println("produced: " + count++);
                            list.add(count);
                            notify();
                        }

                    }
                    if (name.equals("cons")) {
                        synchronized (this) {
                            while (list.isEmpty()) {
                                wait(1000);
                            }
                            System.out.println("consumed: " + list.remove(0));
                            notify();
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted" + Thread.currentThread().getName());
                }
            }
        }
    }
    //dimond problem
class A
{
    public void display()
    {
        System.out.println("class A display() method called");
    }
}
class B extends A
{
    @Override
    public void display()
    {
        System.out.println("class B display() method called");
    }
}
class C extends A
{
    @Override
    public void display()
    {
        System.out.println("class C display() method called");
    }
}
//not supported in Java
class D //cannot extends multiple class extends B,C
{
    public static void main(String args[])
    {
        D d = new D();
        //creates ambiguity which display() method to call
        //d.display();
    }
}

