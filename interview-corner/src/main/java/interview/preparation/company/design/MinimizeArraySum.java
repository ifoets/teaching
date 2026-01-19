package interview.preparation.company.design;

import java.util.Collections;
import java.util.PriorityQueue;

/**k no of operation
 * t some crateria no
 */
public class MinimizeArraySum {

    public static int minimizeSum(int[]a, int k, int t)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x:a)pq.add(x);
        while (k>0&&!pq.isEmpty())
        {
            int max = pq.poll();
            int minmiseByHalf=max/2;
            int minmiseBySubtract = max>=t?t:0;
            if(minmiseByHalf>=minmiseBySubtract)
            pq.add(max/2);
            else pq.add(max-t);
            k--;
        }
        int sum=0;
        for(int i:pq)sum+=i;
        return sum;
    }
//8,7,5,4,2,
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 8, 7};
        int k = 2;
        int t = 3;

        System.out.println(minimizeSum(arr, k, t));
    }
}
