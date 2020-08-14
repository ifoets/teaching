/**
 * 
 */
package com.design.analysis.ds.graph.node;

/**
 * @author @Gurug
 *
 *         This node used to link another node
 */
public class GLNode<V, W> {

	public V v;
	public GLNode<V, W> next;
	public boolean visited;
	public W wt;

	public GLNode(V v) {
		this.v = v;
		this.visited = false;
	}

	public GLNode(V v, W w) {
		this.v = v;
		this.wt = w;
		this.visited = false;
	}
}
