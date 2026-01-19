package com.design.analysis.algo.math.easy;

public class MathEasyImpl implements IMathEasy{
    /**9. Palindrome Number**/
    @Override
    public boolean isPalindrome(int x){
        if(x<0)return false;
        int no = x;
        int result=0;
        while (x!=0)
        {
            result = result*10+x%10;
            x=x/10;
        }
        return result==no;
    }
}
