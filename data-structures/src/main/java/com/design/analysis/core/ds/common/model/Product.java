package com.design.analysis.core.ds.common.model;

public class Product implements Comparable<Product> {

	public int pTypeId;// product type id like car, computer, mobile etc type id
	public int pid;// product id used for key2
	public int mno;// model no; used for key3
	public String ptype;// product type used for key1
	public String pName;// product name

	// use for 2-keys
	public Product(int pid, int mno, String ptype, String pName) {
		super();
		this.pid = pid;
		this.mno = mno;
		this.ptype = ptype;
		this.pName = pName;
	}

	// use for 3-keys
	public Product(int pTypeId, int pid, int mno, String ptype, String pName) {
		super();
		this.pTypeId = pTypeId;
		this.pid = pid;
		this.mno = mno;
		this.ptype = ptype;
		this.pName = pName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mno;
		result = prime * result + pid;
		result = prime * result + ((ptype == null) ? 0 : ptype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (mno != other.mno)
			return false;
		if (pid != other.pid)
			return false;
		if (ptype == null) {
			if (other.ptype != null)
				return false;
		} else if (!ptype.equals(other.ptype))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Product o) {
		return this.mno - o.mno;
	}

	@Override
	public String toString() {
		return "Product [mno=" + mno + ",pid=" + pid + ",ptype=" + ptype + ", pName=" + pName + "]";
	}
	
	public String toStringforTreeLink() {
		return "Product [pTypeId=" + pTypeId + ", pName=" + pName + "]";
	}
	
	public String toStringforTree() {
		return "Product [pid=" + pid + ", pName=" + pName + "]";
	}
}
