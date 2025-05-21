package interview.preparation.company.interviews.question;

public interface


IJio {

	/*
	 * 1 how to design system so if we have 100K customer to handle/purchase product
	 * but if 1000k suddenly increase then also we don't want to lose customer, and
	 * we perform 100k properly use/keep volatile counter in distributed cache , so
	 * even 100 ms running in different server they can communicate from cache
	 */

	/*
	 * Two sorted array a1 and a2, a2 have some element and extra space of size a1
	 * sort without extra space and complexity n arr1 m [3,4,9,10,20] arr2 n with m
	 * space [ ,1,2, ,8,11, ,13, , ]
	 */
	 void specialSort(int []a, int []b);
}
