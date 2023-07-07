/**
 * 
 */
package com.design.analysis.core.ds.linklist.node;

/**
 * @author @Gurug
 *
 */
public class SLNode<K> {

	public K k;
	public SLNode<K> next;

	public SLNode(K k) {
		this.k = k;
		this.next = null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SLNode<K> other = (SLNode<K>) obj;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		return true;
	}

}
