package com.design.analysis.core.algo.interview;

public class GeneralImpl implements IGeneral {

	/** given n pillor find how much water trap if raning happen **/
	@Override
	public int quantityofWaterTrap(int a[]) {

		int waterTrap = 0;
		// first and last pillor will not trap any water
		for (int i = 1; i < a.length - 1; i++) {
			int rMmax = findRightSideBiggestPillor(i, a);
			int lMax = findLeftSideBiggestPillor(i, a);
			waterTrap += Math.abs(Math.abs(rMmax - lMax) - a[i]);
		}
		return waterTrap;

	}

	@Override
	public int findRightSideBiggestPillor(int i, int a[]) {
		int max = a[i];
		for (int j = i + 1; j < a.length; j++) {
			if (max < a[j])
				max = a[j];
		}
		return max;
	}

	@Override
	public int findLeftSideBiggestPillor(int i, int a[]) {
		int max = a[i];
		for (int j = i; j >= 0; j--) {
			if (max < a[j])
				max = a[j];
		}
		return max;
	}

	/** find the max 1 in (0,1) sorted row matrix by O(nlog(n)) comlexity **/
	public int findMax1Row(int a[][]) {
		int max = 0;
		int lenOfOne = 0;
		int maxIndexRow = 0;
		int N = a[0].length;
		for (int i = 0; i < a.length; i++) {
			int lastOneIndex = binarySearchOfLastIndex(a[i], 0, 0, a.length - 1);
			if (lastOneIndex == -1)
				return i;
			lenOfOne = N - lastOneIndex;
			if (max < lenOfOne) {
				max = lenOfOne;
				maxIndexRow = i;
			}
		}
		return maxIndexRow;
	}

	public int binarySearchOfLastIndex(int a[], int x, int l, int r) {

		if (l < r) {
			int m = (l + r) / 2;
			if (a[m] == x && a[m + 1] == 1)
				return m;
			else if (a[m] == x && a[m + 1] == x)
				return binarySearchOfLastIndex(a, x, m + 1, r);
			return binarySearchOfLastIndex(a, x, l, m);
		}
		return -1;
	}
}
