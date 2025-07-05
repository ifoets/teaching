package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.ITesco;

public class TescoImpl implements ITesco {

    /**Get Max price to buy and shell stocks in different days*/
    @Override
    public int getMaxGainInStock(int[] s){

        int minVal = Integer.MAX_VALUE;
        int maxPrice =0;
        for (int i : s) {
            if (minVal > i)
                minVal = i;
            else
                maxPrice = Math.max(maxPrice, i - minVal);
        }
        return maxPrice;
    }
}
