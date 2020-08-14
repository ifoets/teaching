package com.design.analysis.company.hakarrank.visa;

import java.util.List;

import com.design.analysis.company.hakarrank.visa.model.VPoint;

public interface IVisa {

	/**
	 * Card Removal problem.... John has n cards. He is a playing a game with his
	 * friend Bob. In each turn they remove half of the cards.But they cannot
	 * perform this move if the number of cards remaining are odd. Calculate the
	 * number of times they can perform this move.
	 */
	public int noOfTimesCardRemove(int n);

	/** VISA and String Encryption **/
	// k is the window size
	public String visaEncryptString(String s, int k);

	/** Rotation Queries **/
	// command 1, x rotate array right, command 2 y rotate array x, command 3 l r
	// find sum form l to r
	public void leftRotation(int arr[], int k, int c);

	public void rvereseArray(int arr[], int start, int end);

	public int sumQuery(int a[], int l, int r);

	/** XOR And Queries **/
	// public int xor(int... x);

	// public void findsSubArray(int a[]);

	/** Square with minimum area enclosing K points among given N points **/
	// point should not touch the mimimum squre of K points under squre*/

	public long distBtnPoints(VPoint p1, VPoint p2);

	public List<VPoint> kClogestPoint(List<VPoint> pl, VPoint p, int k);

	public long minArea(List<Integer> x, List<Integer> y, int k);

	public int minAreaCoverPointsCompletly(List<VPoint> pl);

	/** Supermarket price invention **/
	// find the size of decresing of k size sub arrays in array
	public int sizeOfSuperMarket(int a[], int k);

	/**
	 * Given a number of vertices, find the number of ways deges can be drawn
	 * between them. it is not ncessary to connect all edge or from connected
	 * components per
	 **/
	// public int drawEdge(int n);
}
