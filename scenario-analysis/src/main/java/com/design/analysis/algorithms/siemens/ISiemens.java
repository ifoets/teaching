package com.design.analysis.algorithms.siemens;

import java.io.IOException;

public interface ISiemens {

	/**
	 * Find duplicates in a file containing 6 digit numbers (like u id) in O (n)
	 * time.
	 **/
	public int findDuplicateInFile() throws IOException;

	/** Given an integer N. Convert it into MS Excel column string. **/
	public String interToMsExcelCol(int n);
}
