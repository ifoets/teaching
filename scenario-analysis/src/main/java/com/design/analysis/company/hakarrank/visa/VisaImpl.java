package com.design.analysis.company.hakarrank.visa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.design.analysis.company.hakarrank.visa.model.VDPoint;
import com.design.analysis.company.hakarrank.visa.model.VPoint;

public class VisaImpl implements IVisa {

	/** card Removal problem **/
	public int noOfTimesCardRemove(int n) {
		int count = 0;
		while (n % 2 != 1) {
			n -= n / 2;
			count++;
		}
		return count;
	}

	/** VISA and String Encryption **/
	// k is the window size
	public String visaEncryptString(String s, int k) {

		int N = s.length();
		int constant;
		int vowel;
		s = s.toLowerCase();
		String encyStr = "";
		for (int i = 0; i <= N - k; i++) {
			constant = 0;
			vowel = 0;
			int t = i;
			for (int j = i; j < k + t; j++) {
				char ch = s.charAt(j);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
					vowel++;
				else
					constant++;
			}
			encyStr += constant * vowel;
		}
		return encyStr;
	}

//c==1 for right rotation and c=2 for left rotation
	public void leftRotation(int arr[], int k, int c) {
		int n = arr.length;
		k = k % n;
		if (c == 1)
			k = n - k;
		rvereseArray(arr, 0, k - 1);
		rvereseArray(arr, k, n - 1);
		rvereseArray(arr, 0, n - 1);
	}

	public void rvereseArray(int arr[], int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public int sumQuery(int a[], int l, int r) {
		int sum = 0;
		for (int i = l; i <= r; i++)
			sum += a[i];
		return sum;
	}

	/** XOR And Queries **/
	public static int xor(int... x) {

		int xor = x[0];
		for (int i = 1; i < x.length && x[i] != 0; i++)
			xor ^= x[i];
		return xor;

	}

	public int findsSubArray(int a[], int l, int r) {

		int N = a.length;
		int xor = 0;
		int b[] = null;
		int t;
		for (int i = l; i <= r; i++) {
			for (int j = i; j <= r; j++) {
				b = new int[N];
				t = 0;
				System.out.println();
				for (int k = i; k <= j; k++) {
					b[t++] = a[k - 1];
					System.out.print(k + " ");
				}
				xor ^= xor(b);
			}
		}
		return xor;
	}

	/** Square with minimum area enclosing K points among given N points **/
	// point should not touch the mimimum squre of K points under squre*/
	@Override
	public long distBtnPoints(VPoint p1, VPoint p2) {
		return (long) Math.sqrt((Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)));
	}

	@Override
	public List<VPoint> kClogestPoint(List<VPoint> pl, VPoint p, int k) {
		int N = pl.size();
		List<VDPoint> list = new ArrayList<>();
		List<VPoint> rList = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(new VDPoint(pl.get(i), distBtnPoints(p, pl.get(i))));
		Collections.sort(list);

		for (int i = 0; i < k; i++)
			rList.add(list.get(i).p);
		return rList;
	}

	@Override
	public long minArea(List<Integer> x, List<Integer> y, int k) {
		int minArea = Integer.MAX_VALUE;
		int N = x.size();
		List<VPoint> pl = new ArrayList<>();
		for (int i = 0; i < x.size(); i++)
			pl.add(new VPoint(x.get(i), y.get(i)));

		for (int i = 0; i < N; i++) {
			VPoint p = pl.get(i);
			List<VDPoint> list = new ArrayList<>();
			List<VPoint> rList = new ArrayList<>();
			rList.add(p);
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				list.add(new VDPoint(pl.get(j), distBtnPoints(p, pl.get(j))));
			}
			Collections.sort(list);

			for (int t = 0; t < k - 1; t++)
				rList.add(list.get(t).p);
			int area = minAreaCoverPointsCompletly(rList);
			if (area < minArea)
				minArea = area;
		}
		return minArea;
	}

	/* points are completly inside the area not lie on the line of area */
	@Override
	public int minAreaCoverPointsCompletly(List<VPoint> pl) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < pl.size(); i++) {
			min = Math.min(min, Math.min(pl.get(i).x, pl.get(i).y));
			max = Math.max(max, Math.max(pl.get(i).x, pl.get(i).y));
		}
		// for covering all point move digonally up and down
		min -= 1;
		max += 1;
		int side = Math.abs(max - min);
		return side * side;
	}

	/** Supermarket price invention **/
	// find the size of decresing of k size sub arrays in array
	public int sizeOfSuperMarket(int a[], int k) {

		// k is no of loop in
		int N = a.length;
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int l = j + 1; l < N; l++) {
					if (a[i] > a[j] && a[j] > a[l] && i < j && j < l) {
						count++;
					}
				}
			}
		}
		return count;
	}

}
