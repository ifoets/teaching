package com.design.analysis.core.algo.backtracking;

import com.design.analysis.core.algo.backtracking.utils.BackTrackingUtils;

public class BackTrackingMiscImpl implements IBackTrackingMisc {

	/** 1. Tug of War **/
	public void turofWar(int arr[]) {

		int n = arr.length;

		// the boolen array that contains the
		// inclusion and exclusion of an element
		// in current set. The number excluded
		// automatically form the other set
		boolean[] curr_elements = new boolean[n];

		// The inclusion/exclusion array for
		// final solution
		boolean[] soln = new boolean[n];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			curr_elements[i] = soln[i] = false;
		}

		// Find the solution using recursive
		// function TOWUtil()
		BackTrackingUtils.TOWUtil(arr, n, curr_elements, 0, soln, sum, 0, 0);

		// Print the solution
		System.out.print("The first subset is: ");
		for (int i = 0; i < n; i++) {
			if (soln[i] == true)
				System.out.print(arr[i] + " ");
		}
		System.out.print("\nThe second subset is: ");
		for (int i = 0; i < n; i++) {
			if (soln[i] == false)
				System.out.print(arr[i] + " ");
		}
	}
}
