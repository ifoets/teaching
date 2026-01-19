package interview.preparation.company.design;

import java.util.Stack;
/** You have an array of Integer =
 {8,8,1,5,5,5,1,1,8}. Keep removing 3 repeating elements from the array. If at end, array becomes empty return true else false.
 */
public class RemoveKRepetingElem {

    public static boolean removeKElemIfTogether(int[] a, int k){
        if(a==null|| a.length==0)return true;

        Stack<Integer> stack = new Stack<>();
        int currentElemCount=0;
        for (int i=0;i<a.length;i++)
        {

           if(!stack.isEmpty()&&stack.peek()==a[i]) {
               currentElemCount++;
           }
           else {
               currentElemCount=1;
           }
            stack.push(a[i]);
            if(currentElemCount==k)
            {
                int counter=k;
                while (counter-->0)
                    stack.pop();
                if(!stack.isEmpty()) {
                    int currentPeek = stack.peek();
                    int cnt=0;
                    while (!stack.isEmpty()&&currentPeek==stack.peek())
                    {
                        cnt++;
                        stack.pop();
                    }
                    int m=cnt;
                    while (cnt-->0)stack.push(currentPeek);
                    currentElemCount=m;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a={8,8,1,5,5,5,1,1,8};
        System.out.println(removeKElemIfTogether(a,3));

    }
}
