package com.design.analysis.core.ds.common.model;

public class ProductTestUtils {

	public static Product[] producForLink() {
		Product arr[] = new Product[9];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(0, 1, 11, "0.aaple", "computer");
			arr[k++] = new Product(0, 2, 12, "0.aaple", "watch");
			arr[k++] = new Product(0, 3, 13, "0.aaple", "mobile");

			arr[k++] = new Product(1, 4, 14, "1.car", "bmw");
			arr[k++] = new Product(1, 5, 15, "1.car", "tata");
			arr[k++] = new Product(1, 6, 16, "1.car", "honda");

			arr[k++] = new Product(2, 7, 17, "2.lenavo", "watch");
			arr[k++] = new Product(2, 8, 18, "2.lenavo", "mobile");
			arr[k++] = new Product(2, 9, 19, "2.lenavo", "desktop");
		}
		return arr;
	}

	public static Product[] producForTreeLink() {
		Product arr[] = new Product[21];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(3, 1, 11, "3.aaple", "computer");
			arr[k++] = new Product(3, 2, 12, "3.aaple", "watch");
			arr[k++] = new Product(3, 3, 13, "3.aaple", "mobile");

			arr[k++] = new Product(2, 4, 14, "2.car", "bmw");
			arr[k++] = new Product(2, 5, 15, "2.car", "tata");
			arr[k++] = new Product(2, 6, 16, "2.car", "honda");

			arr[k++] = new Product(5, 7, 17, "5.lenavo", "watch");
			arr[k++] = new Product(5, 8, 18, "5.lenavo", "mobile");
			arr[k++] = new Product(5, 9, 19, "5.lenavo", "desktop");

			arr[k++] = new Product(0, 1, 21, "0.gold", "ring");
			arr[k++] = new Product(0, 2, 22, "0.gold", "necklace");
			arr[k++] = new Product(0, 3, 23, "0.gold", "watch");

			arr[k++] = new Product(1, 4, 24, "1.textile", "shirt");
			arr[k++] = new Product(1, 5, 25, "1.textile", "paint");
			arr[k++] = new Product(1, 6, 26, "1.textile", "teshirt");

			arr[k++] = new Product(4, 7, 27, "4.book", "programming");
			arr[k++] = new Product(4, 8, 28, "4.book", "desing");
			arr[k++] = new Product(4, 9, 29, "4.book", "analysis");

			arr[k++] = new Product(6, 7, 37, "6.mobile", "samsung");
			arr[k++] = new Product(6, 8, 38, "6.lenavo", "apple");
			arr[k++] = new Product(6, 9, 39, "6.lenavo", "nokia");
		}
		return arr;
	}

	public static Product[] producForTree() {
		Product arr[] = new Product[9];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 1; i++) {

			arr[k++] = new Product(1, 5, 24, "1.textile", "shirt");
			arr[k++] = new Product(1, 7, 25, "1.textile", "paint");
			arr[k++] = new Product(1, 3, 26, "1.textile", "teshirt");

			arr[k++] = new Product(1, 2, 27, "4.book", "programming");
			arr[k++] = new Product(1, 6, 28, "4.book", "desing");
			arr[k++] = new Product(1, 4, 29, "4.book", "analysis");

			arr[k++] = new Product(1, 8, 37, "6.mobile", "samsung");
			arr[k++] = new Product(1, 9, 38, "6.lenavo", "apple");
			arr[k++] = new Product(1, 1, 39, "6.lenavo", "nokia");
		}
		return arr;
	}

	public static Product[] producForLinkTree() {
		Product arr[] = new Product[21];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(3, 3, 11, "3.aaple", "computer");
			arr[k++] = new Product(3, 5, 12, "3.aaple", "watch");
			arr[k++] = new Product(3, 2, 13, "3.aaple", "mobile");

			arr[k++] = new Product(3, 6, 14, "2.car", "bmw");
			arr[k++] = new Product(3, 4, 15, "2.car", "tata");
			arr[k++] = new Product(3, 1, 16, "2.car", "honda");

			arr[k++] = new Product(5, 3, 17, "5.lenavo", "watch");
			arr[k++] = new Product(5, 5, 18, "5.lenavo", "mobile");
			arr[k++] = new Product(5, 2, 19, "5.lenavo", "desktop");

			arr[k++] = new Product(5, 6, 21, "0.gold", "ring");
			arr[k++] = new Product(5, 4, 22, "0.gold", "necklace");
			arr[k++] = new Product(5, 0, 23, "0.gold", "watch");

			arr[k++] = new Product(1, 5, 24, "1.textile", "shirt");
			arr[k++] = new Product(1, 7, 25, "1.textile", "paint");
			arr[k++] = new Product(1, 3, 26, "1.textile", "teshirt");

			arr[k++] = new Product(1, 2, 27, "4.book", "programming");
			arr[k++] = new Product(1, 6, 28, "4.book", "desing");
			arr[k++] = new Product(1, 4, 29, "4.book", "analysis");

			arr[k++] = new Product(1, 8, 37, "6.mobile", "samsung");
			arr[k++] = new Product(1, 9, 38, "6.lenavo", "apple");
			arr[k++] = new Product(1, 1, 39, "6.lenavo", "nokia");
		}
		return arr;
	}

	public static Product[] producForUnrollList() {
		Product arr[] = new Product[23];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(3, 1, 0, "3.aaple", "computer");
			arr[k++] = new Product(3, 2, 1, "3.aaple", "watch");
			arr[k++] = new Product(3, 3, 2, "3.aaple", "mobile");
			arr[k++] = new Product(3, 2, 3, "3.aaple", "watch");
			arr[k++] = new Product(3, 3, 4, "3.aaple", "mobile");

			arr[k++] = new Product(2, 4, 0, "2.car", "bmw");
			arr[k++] = new Product(2, 5, 2, "2.car", "tata");
			arr[k++] = new Product(2, 6, 1, "2.car", "honda");
			arr[k++] = new Product(2, 2, 4, "3.aaple", "watch");
			arr[k++] = new Product(2, 3, 3, "3.aaple", "mobile");

			arr[k++] = new Product(5, 7, 0, "5.lenavo", "watch");
			arr[k++] = new Product(5, 8, 1, "5.lenavo", "mobile");
			arr[k++] = new Product(5, 9, 2, "5.lenavo", "desktop");
			arr[k++] = new Product(5, 2, 4, "5.aaple", "watch");
			arr[k++] = new Product(5, 3, 3, "5.aaple", "mobile");

			arr[k++] = new Product(1, 1, 0, "1.gold", "ring");
			arr[k++] = new Product(1, 2, 1, "1.gold", "necklace");
			arr[k++] = new Product(1, 3, 2, "1.gold", "watch");
			arr[k++] = new Product(1, 2, 3, "1.aaple", "watch");
			arr[k++] = new Product(1, 3, 4, "1.aaple", "mobile");

			arr[k++] = new Product(4, 4, 0, "4.textile", "shirt");
			arr[k++] = new Product(4, 5, 2, "4.textile", "paint");
			arr[k++] = new Product(4, 6, 4, "4.textile", "teshirt");

		}
		return arr;
	}
}
