package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IHarman;

import java.util.Arrays;
import java.util.Comparator;

public class HarmanImpl implements IHarman {
    /*find kth max/min element from a positive array*/
    public int kthMaxMin(int a[], int k, boolean maxOrMin) {
        int max = Arrays.stream(a).max().getAsInt();
        int b[] = new int[max + 1];
        for (int i = 0; i < a.length; b[a[i++]]++) ;

        if (maxOrMin) {
            for (int i = b.length - 1; i >= 0; i--) {
                if (b[i] != 0) {
                    k--;
                    if (k == 0)
                        return i;
                }
            }
        } else {

            for (int i = 0; i < b.length; i++) {
                if (b[i] != 0) {
                    k--;
                    if (k == 0)
                        return i;
                }
            }
        }
        return -1;
    }

    /*using java 8*/
    public int kthMaxMinX(int a[], int k, boolean maxOrMin)
    {
        return
        maxOrMin ? Arrays.stream(a).boxed().distinct().sorted(Comparator.reverseOrder()).skip(k-1).findFirst().get()
                 : Arrays.stream(a).boxed().distinct().sorted().skip(k-1).findFirst().get();
    }
}
