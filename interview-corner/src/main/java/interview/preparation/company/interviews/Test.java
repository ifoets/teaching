package interview.preparation.company.interviews;

public class Test {
/*7,1,5,3,6,4*/
    public static void main(String[] args) {
        System.out.println("Hi...");
        int a[] ={7,1,5,3,6,4};
        System.out.println(maxStockPrice(a));
    }

    static int maxStockPrice(int s[])
    {
        int minVal =Integer.MAX_VALUE;
        //int curentPrice=0;
        int maxPrice=0;
        for(int i=0;i<s.length;i++) {
            if (minVal > s[i]) {
                minVal = s[i];
            } else {
                maxPrice = Math.max(maxPrice, s[i] - minVal);

            }
        }
        return maxPrice;
    }

}
