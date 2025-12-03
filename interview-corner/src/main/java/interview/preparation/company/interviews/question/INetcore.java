package interview.preparation.company.interviews.question;

public interface INetcore {
	/* The total number of continuous subarrays */
	 int subArrayCount(int[] a);

	// pattern 1+2+3+..n pattern getting no of continuous sab array
	 int subArrayCountX(int[] a);
	// pattern 1+2+3+..n length pattern getting no of noncontinuous sab array multiply factorial/arrangement
	 int subArrayCountNonContinuous(int[] a);

	/* Count sub-arrays which have elements less than or equal to X */
	 int subArrayLesEqualToX(int[] a, int x);

	/* Number of subarrays having even product */
	 int countSubArrayEvenProd(int[] a);
}
