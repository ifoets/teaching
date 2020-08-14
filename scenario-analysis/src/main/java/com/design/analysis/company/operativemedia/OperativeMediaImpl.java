package com.design.analysis.company.operativemedia;

public class OperativeMediaImpl implements IOperativeMedia {

	/** find the repetative element **/
	public int indexOfRepetativeElem(int a[], int l, int r) {

		if (l < r) {
			int m = (l + r) / 2;

			if (a[0] == a[m])
				return m;
			else if (a[l] < a[m] && a[m] > a[r])
				return indexOfRepetativeElem(a, m + 1, r);
			else
				return indexOfRepetativeElem(a, l, m - 1);
		}
		return -1;
	}
}
