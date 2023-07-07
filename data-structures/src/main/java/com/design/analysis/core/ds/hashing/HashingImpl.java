package com.design.analysis.core.ds.hashing;

import java.util.Arrays;

public class HashingImpl implements IHashing {

	/* used for indexmapping */
	public int indMpTab[][];

	/** Index Mapping (or Trivial Hashing) with negatives allowed **/
	@Override
	public void insertIndexMapping(int[] arr, int maxMinRange) {
		indMpTab = new int[maxMinRange + 1][2];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0)
				indMpTab[arr[i]][0] = arr[i];
			else
				indMpTab[Math.abs(arr[i])][1] = arr[i];
		}

	}

	@Override
	public void printIndexMapping()
	{
		for(int i=0;i<indMpTab.length;i++)
		{
			System.out.println(Arrays.toString(indMpTab[i]));
		}
	}
	
	@Override
	public int searchIndexMapping(int x) {
		
		return x > 0 ? indMpTab[x][0] : indMpTab[Math.abs(x)][1];
	}

	@Override
	public boolean deleteIndexMapping(int x) {

		int y = Math.abs(x);
		if (indMpTab[y][0] == 0 && indMpTab[y][1] == 0)
			return false;
		if (x > 0) {
			indMpTab[y][0] = 0;

		} else {
			indMpTab[y][1] = 0;
		}
		return true;
	}

}
