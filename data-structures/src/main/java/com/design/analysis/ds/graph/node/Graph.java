/**
 * 
 */
package com.design.analysis.ds.graph.node;

/**
 * @author @Gurug
 *
 */
public class Graph<V, W> {
	public Integer vSize;// size of vertex
	public GLNode<V, W>[] gl;

	@SuppressWarnings("unchecked")
	public Graph(Integer vSize) {
		this.vSize = vSize;
		gl = new GLNode[vSize];
	}
}
