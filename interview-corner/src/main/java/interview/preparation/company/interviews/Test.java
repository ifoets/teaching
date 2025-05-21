package interview.preparation.company.interviews;

//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//[4,3,2,1,7,6,5]
//[5,6,7,1,2,3,4]
//2,3,4,5,6,7,8,0,1
//7,8,0,1,2,3,4,5,6

public class Test {

    public static void main(String[] args) {
        System.out.println("Hello..");
    }

    static void rotateKTimes(int a[], int k)
    {
        int N=a.length;
        int l=N-k;
        reverse(a,0,l-1);
        reverse(a,l,N-1);
        reverse(a,0,N-1);
        //System.out.println(Arr);
    }
    static void reverse(int a[], int first, int last)
    {

        while(first<last)
        {
            int temp = a[first];
            a[first] = a[last];
            a[last] = temp;
            first++;
            last--;
        }
    }

    public static int pivot(int a[], int l, int r)
    {

        int m =(l+r)/2;
        while(l<=r)
        {
            if(a[m]>a[m+1])
                return m;
            if(a[m]<a[r])
                return pivot(a,l,m-1);
            else if(a[l]>a[m])
                return pivot(a,m+1,r);
                else return -1;
        }
        return -1;
    }
    public static int binarySerach(int a[], int x, int l, int r)
    {
        int m =(l+r)/2;
        while(l<=r)
        {
            if(a[m]==x)
                return m;
            if(a[m]<a[r])
                return pivot(a,l,m-1);
            else
                return pivot(a,m+1,r);
        }
        return -1;
    }
}
