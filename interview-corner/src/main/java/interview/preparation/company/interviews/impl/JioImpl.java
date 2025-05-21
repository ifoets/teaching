package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IJio;

import java.util.Arrays;

public class JioImpl implements IJio {

	@Override
	public void specialSort(int []a, int []b) {

		// shift all zero of b to left as keep sorted order
		int N = b.length - 1;
		int k = N;
		int i = N;
		while (i > 0) {
			while (b[k] != 0)
				k--;
			while (i > 0 && b[i] == 0)
				i--;
			if (k > 0 && i > 0) {
				b[k] = b[i];
				b[i] = 0;
			}
		}
		// k is the last zero in b
		i = 0;
		int j = k + 1;
		int t = 0;
		while (i < a.length && j < N + 1 && t < N + 1) {
			if (a[i] > b[j]) {
				b[t] = b[j];
				b[j] = 0;
				t++;
				j++;
			} else {
				b[t] = a[i];
				t++;
				i++;
			}
		}
		if (j >= N) {
			while (i < a.length)
				b[t++] = a[i++];
		}
		System.out.println(Arrays.toString(b));

	}
}
