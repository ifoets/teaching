package interview.preparation.self.basic.prep;

import java.util.stream.IntStream;

public class Permutaitoni {

	public static void main(String[] args) {

		stringPermuteAndPrint("", "ABC");
	}

	// java 8 stream example
		private static void stringPermuteAndPrint(String prefix, String str) {
			int n = str.length();
			if (n == 0) {
				System.out.print(prefix + " ");
			} else {
				IntStream.range(0, n).parallel().forEach(
						i -> stringPermuteAndPrint(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
			}
		}

}

class PrintOddEven implements Runnable{
	 
    public int MAX_NUMBER =10;
    static int  number=1;
    int rem;
    static Object lock=new Object();
 
    PrintOddEven(int remainder)
    {
        this.rem =remainder;
    }
 
    @Override
    public void run() {
        while (number < MAX_NUMBER) {
            synchronized (lock) {
                while (number % 2 != rem) { // wait
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}
 class OddEvenMain {
    public static void main(String[] args) {
 
        PrintOddEven oddRunnable=new PrintOddEven(1);
        PrintOddEven evenRunnable=new PrintOddEven(0);
 
        Thread t1=new Thread(oddRunnable,"T1");
        Thread t2=new Thread(evenRunnable,"T2");
 
        t1.start();
        t2.start();
 
    }
}
