package com.design.analysis.algo.simulation.medium;

public class SimulationMediumImpl implements ISimulationMedium{

    /**43. Multiply Strings, Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string**/
    @Override
    public String multiply(String num1, String num2){

       //just like reverse two string and keep digit multiplication/10 at i+j and % at i+j+1
        int m = num1.length();
        int n = num2.length();
        int[] num = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + num[p2];
                num[p1] += sum / 10;
                num[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : num) {
            if (!(sb.isEmpty() && x == 0)) {
                sb.append(x);
            }
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

}
