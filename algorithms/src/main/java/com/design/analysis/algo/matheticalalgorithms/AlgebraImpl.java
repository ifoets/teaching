package com.design.analysis.algo.matheticalalgorithms;

import java.util.ArrayList;
import java.util.List;

public class AlgebraImpl implements IAlgebra {

	public List<Integer> findXAndY(int a, int b, int n) {
		// ax+yby =n;
		List<Integer> list = new ArrayList<>();
		// traverse for all possible values
		for (int i = 0; i * a <= n; i++) {

			// check if it is satisfying the equation
			if ((n - (i * a)) % b == 0) {
				list.add(i);
				list.add((n - (i * a)) / b);
				System.out.println("x = " + i + ", y = " + (n - (i * a)) / b);
				return list;
			}
		}
		System.out.println("No solution");
		return null;
	}

	/** 2. Calculate the Discriminant Value **/
	@Override
	public int discriminantValue(int a, int b, int c) {

		int discriminant = (int) (Math.pow(b, 2) - 4 * a * c);
		if (discriminant > 0) {
			System.out.println("Discriminant is " + discriminant + " which is Positive");
			System.out.println("Hence Two Solutions");
		} else if (discriminant == 0) {
			System.out.println("Discriminant is " + discriminant + " which is Zero");
			System.out.println("Hence One Solution");
		} else {
			System.out.println("Discriminant is " + discriminant + " which is Negative");
			System.out.println("Hence No Real Solutions");
		}
		return discriminant;
	}

	/** 2. Calculate the Discriminant Value **/
	static int n = 3;

	public int dotProduct(int vect_A[], int vect_B[]) {

		int product = 0;

		// Loop for calculate cot product
		for (int i = 0; i < n; i++)
			product = product + vect_A[i] * vect_B[i];
		return product;
	}

	// cross product of two vector array.
	public void crossProduct(int vect_A[], int vect_B[], int cross_P[]) {

		cross_P[0] = vect_A[1] * vect_B[2] - vect_A[2] * vect_B[1];
		cross_P[1] = vect_A[0] * vect_B[2] - vect_A[2] * vect_B[0];
		cross_P[2] = vect_A[0] * vect_B[1] - vect_A[1] * vect_B[0];
	}

	/** 5. Program to find correlation coefficient **/
	// function that returns correlation coefficient.
	public float correlationCoefficient(int X[], int Y[], int n) {
		int sum_X = 0, sum_Y = 0, sum_XY = 0;
		int squareSum_X = 0, squareSum_Y = 0;

		for (int i = 0; i < n; i++) {
			// sum of elements of array X.
			sum_X = sum_X + X[i];

			// sum of elements of array Y.
			sum_Y = sum_Y + Y[i];

			// sum of X[i] * Y[i].
			sum_XY = sum_XY + X[i] * Y[i];

			// sum of square of array elements.
			squareSum_X = squareSum_X + X[i] * X[i];
			squareSum_Y = squareSum_Y + Y[i] * Y[i];
		}

		// use formula for calculating correlation
		// coefficient.
		float corr = (float) (n * sum_XY - sum_X * sum_Y)
				/ (float) (Math.sqrt((n * squareSum_X - sum_X * sum_X) * (n * squareSum_Y - sum_Y * sum_Y)));
		return corr;
	}
}
