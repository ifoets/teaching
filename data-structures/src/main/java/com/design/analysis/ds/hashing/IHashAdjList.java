package com.design.analysis.ds.hashing;

import com.design.analysis.ds.common.Hash;

public interface IHashAdjList {

	public void addHashNode(Hash h, String value);

	public boolean equals(String used, String exists);

	public int hashCode(int size, String value);

	public int getKey(String value);
	
	public void print(Hash h);

}
