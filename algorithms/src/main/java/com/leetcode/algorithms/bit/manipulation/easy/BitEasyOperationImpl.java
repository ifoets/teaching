package com.leetcode.algorithms.bit.manipulation.easy;

public class BitEasyOperationImpl implements IBitEasyOperation {

    /**67. Add Binary number*/
    @Override
    public String addBinary(String a, String b){

        StringBuilder sb = new StringBuilder();

        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while (i>=0 || j>=0 || carry>0)
        {
            int bitA = i>=0?a.charAt(i--)-'0':0;
            int bitB = j>=0?b.charAt(j--)-'0':0;
            int sum = bitA+bitB+carry;
            sb.append(sum%2);
            carry=sum/2;
        }
        return sb.reverse().toString();
    }
    /**Analysis on Add Binary number*/
    @Override
    public int addNumberByBitOptr(int a, int b){

        while (b!=0)
        {
            int carry = (a&b)<<1; //get carry
            a=a^b; //add bit nos a and b without carry
            b=carry; //continuously add carry to sum till it will zero
        }
        return a;
    }

    /**a-b=a+(-b), -b is tow's complement of b ie ~b+1 ie -b == ~b+1 is true*/
    @Override
    public int subtractNumberByBitOptr(int a, int b){
        int negB = addNumberByBitOptr(~b,1);
        return addNumberByBitOptr(a,negB);
    }

    @Override
    public int multipleNumberByBitOptr(int a, int b){
      int result = 0;

      while (b!=0)
      {
          //if last bit of b is 1 add to result
          if((b&1)==1)
          {
              result = addNumberByBitOptr(result,a);
          }
          //left shift a
          a<<=1;
          //unsigned right shift of b
          b>>>=1;
      }
      return result;
    }
}
