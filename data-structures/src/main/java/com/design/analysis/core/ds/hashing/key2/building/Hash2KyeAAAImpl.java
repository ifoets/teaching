package com.design.analysis.core.ds.hashing.key2.building;

public class Hash2KyeAAAImpl implements IHash2KyeAAA<Integer, Integer, Integer> {

	public int KEY1_SIZE = 100;
	public int KEY2_SIZE = 10;
	public int VALUE_SIZE = 2;
	public Integer table[][][] = null; // FOR +VE/-VE VALUE

	/* add mass of element in single shot */
	@Override
	public void addArray(Integer key1[], Integer key2[], Integer a[], Integer tableSize) {
		if (tableSize != null)
			KEY1_SIZE = tableSize;
		table = new Integer[KEY1_SIZE][KEY2_SIZE][VALUE_SIZE];

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0)
				table[key1[i]][key2[i]][0] = a[i];
			else
				table[Math.abs(key1[1])][Math.abs(key2[i])][1] = a[i];
		}
	}

	/* add an element */
	@Override
	public void addElement(Integer key1, Integer key2, Integer x) {

		if (table == null)
			table = new Integer[KEY1_SIZE][KEY2_SIZE][VALUE_SIZE];
		if (x > 0)
			table[key1][key2][0] = x;
		else
			table[Math.abs(key1)][Math.abs(key2)][1] = x;
	}

	/* find an element */
	@Override
	public Integer getElement(Integer key1, Integer key2, boolean isSign) {

		if (table != null)
			return isSign ? table[key1][key2][0] : table[Math.abs(key1)][Math.abs(key2)][1];
		return null;
	}

	/* delete an element */
	@Override
	public boolean deleteElement(Integer y) {
		boolean found = false;

		if (table != null) {
			int key1 = hashKey1(Math.abs(y));
			int key2 = hashKey2(Math.abs(y));
			if (y > 0 && table[key1][key2][0] != null && table[key1][key2][0].equals(y)) {
				table[key1][key2][0] = null;
				found = true;
			} else {
				if (table[key1][key2][1] != null && table[key1][key2][1].equals(y)) {
					table[key1][key2][1] = null;
					found = true;
				}
			}
		}
		return found;
	}

	/* destroy cache */
	@Override
	public void destroyCache() {
		table = new Integer[KEY1_SIZE][KEY2_SIZE][VALUE_SIZE];
	}

	/* a way to find the key */
	@Override
	public int hashKey1(Integer x) {
		return (int) (x / 100);
	}

	/* a way to find key2 */
	@Override
	public int hashKey2(Integer x) {
		return (int) (x % 100);
	}

	/* print all the element if found */
	@Override
	public void print() {

		if (table != null) {
			for (int i = 0; i < table.length; i++) {
				System.out.println();
				for (int j = 0; j < table[i].length; j++) {
					System.out.println();
					for (int k = 0; k < 2; k++) {
						if (table[i][j][k] != null)
							System.out.print(table[i][j][k] + ", ");
					}
				}
			}
		}
	}

}
