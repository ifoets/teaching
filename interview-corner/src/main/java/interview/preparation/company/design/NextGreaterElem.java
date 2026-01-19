package interview.preparation.company.design;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElem {

    static int[] nextGreaterElem(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(a[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[]a={4, 1, 3, 5, 6, 2, 7, 8};

        int[]o= {5, 2, 5, 6, 7, 7, 8, -1};

        System.out.println(Arrays.toString(nextGreaterElem(a)));
    }
}
