package com.design.analysis.core.algo.matheticalalgorithms;

import java.util.List;

/*
 * 
 * @author GuruG
 * 
 * Prime Factorization and Divisors :
1.	Prime factors
2.	Smith Numbers
3.	Sphenic Number
4.	Hoax Number
5.	k-th prime factor of a given number
6.	Pollard�s Rho Algorithm for Prime Factorization
7.	Prime Factorization using Sieve O(log n) for multiple queries
8.	Find politeness of a number
9.	Find sum of even factors of a number
10.	Find sum of odd factors of a number
11.	Find largest prime factor of a number
12.	Find minimum sum of factors of number
13.	Finding power of prime number p in n!
14.	Find all divisors of a natural number | Set 1
15.	Find all divisors of a natural number | Set 2
16.	Find all divisors of a natural number
17.	Find numbers with n-divisors in a given range
18.	Find minimum number to be divided to make a number a perfect square
19.	Sum of all proper divisors of a natural number
20.	Sum of all the factors of a number
21.	Sum of largest prime factor of each number less than equal to n
22.	Sum of all divisors from 1 to n
23.	Check for Amicable Pair
24.	Prime Factorization using Sieve O(log n) for multiple queries
25.	Prime factors of a big number

 */
public interface IPrimeFactAndDivisor {

	/** 1. Prime factors **/
	public List<Integer> primeFactors(int n);

	/** 2. Smith Numbers **/
	public boolean isSmithNumber(int n);

	/** 3. Sphenic Number **/
	public boolean isSphenicNumber(int n);

	/** 4. Hoax Number **/
	public boolean hoaxNumber(int n);
	/** 5. k-th prime factor of a given number **/

	/** 6. Pollard�s Rho Algorithm for Prime Factorization **/
	/* return any prime no or divisor */
	/** 7. Prime Factorization using Sieve O(log n) for multiple queries **/
	public List<Integer> primeFactorization(int n);

	/** 8. Find politeness of a number **/
	public int politenessOfNum(int n);
	/** 9. Find sum of even factors of a number **/
	/** 10. Find sum of odd factors of a number **/
	/** 11. Find largest prime factor of a number **/
	/* 12. Find minimum sum of factors of number */
	/* 13. Finding power of prime number p in n! */
	/* 14. Find all divisors of a natural number | Set 1 */
	/* 15. Find all divisors of a natural number | Set 2 */
	/* 16. Find all divisors of a natural number */
	/* 17. Find numbers with n-divisors in a given range */
	/* 18. Find minimum number to be divided to make a number a perfect square */
	/* 19. Sum of all proper divisors of a natural number */
	/* 20. Sum of all the factors of a number */
}
