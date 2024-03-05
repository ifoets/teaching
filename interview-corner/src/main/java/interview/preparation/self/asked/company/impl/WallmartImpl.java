package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IWallmart;

public class WallmartImpl implements IWallmart {

    /*remove continuous duplicate character from words in String*/
    @Override
    public String removeContinuousChar(String str){
        if(str==null || str.length()==0)
            return str;
        char arr[] = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);

        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]!=arr[i+1])
                sb.append(arr[i+1]);
        }
        return sb.toString();
    }

    /*wrote a function that check weather an array is sub array of another array, return true or false*/
    @Override
    public boolean checkArrayIsSubArray(int a[], int b[])
    {
        if(b==null || b.length==0)
            return true;
        if(a==null && b==null || a.length==0 && b.length ==0)
            return true;
        if(b.length > a.length)
            return false;
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<a.length;j++)
            {
                if(b[i]==a[j])
                    i++;
                if(i==b.length)
                    return true;
            }
        }
        return false;
    }

    /*print vertical dumbbells from "*" */
    @Override
    public void printDumbbell(int n){
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<i;k++)
                System.out.print(" ");
            System.out.print(" ");
            for(int j=i;j<n;j++)
                System.out.print("* ");
            System.out.println();
        }
        for(int i=0;i<n;i++)
        {
            if(i!=0) {
                for (int k = i; k < n - 1; k++)
                    System.out.print(" ");
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++) {
                if(i!=0)
                System.out.print("* ");
            }
            if(i!=0)
            System.out.println();
        }
    }
}
