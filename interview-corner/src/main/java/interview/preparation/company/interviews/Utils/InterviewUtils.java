package interview.preparation.company.interviews.Utils;

public class InterviewUtils {

    public static void reverse(int []a,int l, int r)
    {
        while (l<r)
        {
            int temp = a[l];
            a[l]=a[r];
            a[r]=temp;
            l++;
            r--;
        }
    }

    public static int binarySearch(int []a,int x, int l ,int r){
        int m=(l+r)/2;
        if(l<=r)
        {
            if(x==a[m])
                return m;
            else if( x<a[m])
                return binarySearch(a,x,l,m-1);
            return binarySearch(a,x,m+1,r);
        }
        return -1;
    }
}
