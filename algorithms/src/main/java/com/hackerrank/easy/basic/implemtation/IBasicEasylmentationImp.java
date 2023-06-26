package com.hackerrank.easy.basic.implemtation;

/**Question and details explanation are in corresponding package of src/main/common*/
import java.util.List;

public interface IBasicEasylmentationImp {

	/** Implementation **/ // start....

	/* 1. count Apple and Orange */
	public int[] countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges);

	public long[] countApplesAndOrangesStream(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges);

	/* 2. Number Line Jumps */
	public String kangaroo(int x1, int v1, int x2, int v2);

	/* 3. Between Two Sets */
	public int getTotalX(List<Integer> a, List<Integer> b);

	/* 4. Breaking the Records */
	public List<Integer> breakingRecords(List<Integer> scores);

	/* 5. Subarray Division */
	public int birthday(List<Integer> s, int d, int m);

	/* 6. Divisible Sum Pairs */
	public int divisibleSumPairs(int n, int k, List<Integer> ar);

	/* 7. Migratory Birds */
	public int migratoryBirds(List<Integer> arr);

	public int migratoryBirdsStream(List<Integer> arr);

	/* 8. Day of the Programmer */
	public String dayOfProgrammer(int year);

	/* 9. Bill Division */
	public void bonAppetit(List<Integer> bill, int k, int b);

	/* 10. Sales by Match */
	public int sockMerchant(int n, List<Integer> ar);

	/* 11. Drawing Book */
	public int pageCount(int n, int p);

	/* 12. Counting Valleys */
	public int countingValleys(int steps, String path);

	/* 13. Electronics Shop */
	public int getMoneySpent(int[] keyboards, int[] drives, int b);

	/* 14. Cats and a Mouse */
	public String catAndMouse(int x, int y, int z);

	/* 15. Picking Numbers */
	public int pickingNumbers(List<Integer> a);

	/* The Hurdle Race */
	public int hurdleRace(int k, List<Integer> height);

	/* Designer PDF Viewer */
	public int designerPdfViewer(List<Integer> h, String word);
	/** Implementation **/ // continue....
	/**********************************************************************************************************************************************************************/

}
