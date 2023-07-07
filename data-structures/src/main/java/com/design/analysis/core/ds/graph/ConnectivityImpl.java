package com.design.analysis.core.ds.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.design.analysis.core.ds.graph.da.node.Edge;
import com.design.analysis.core.ds.graph.node.GLNode;
import com.design.analysis.core.ds.graph.node.Graph;
import com.design.analysis.core.ds.graph.utils.GraphUtils;
import com.design.analysis.core.ds.graph.utils.IGraphUtils;

public class ConnectivityImpl implements IConnectivity<Integer, Integer> {

	public IGraphUtils<Integer, Integer> igu = new GraphUtils();

	@Override
	public List<List<Integer>> allPathsBetwnTwoVertex(Graph<Integer, Integer> g, int x, int y) {

		if (g == null) {
			return null;
		}
		int[] path = new int[20];
		List<List<Integer>> list = new ArrayList<>();
		collectPath(g, path, 0, x, y, list);
		return list;
	}

	@Override
	public void collectPath(Graph<Integer, Integer> g, int[] path, int size, int x, int y, List<List<Integer>> list) {
		path[size++] = x;
		if (x == y) {
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < size; i++)
				l.add(path[i]);
			list.add(l);
		} else {
			for (GLNode<Integer, Integer> p = g.gl[x]; p != null; p = p.next) {
				collectPath(g, path, size, p.v, y, list);
			}
		}
	}

	/** 2. Connectivity in a directed graph **/
	@Override
	public boolean isStronglyConnected(Graph<Integer, Integer> g) {

		boolean visited[] = new boolean[g.vSize];

		for (int i = 0; i < g.vSize; i++) {
			visited = new boolean[g.vSize];
			Queue<Integer> que = new LinkedList<>();
			que.add(i);
			visited[i] = true;
			while (!que.isEmpty()) {
				GLNode<Integer, Integer> x = g.gl[que.poll()];
				for (; x != null; x = x.next) {
					if (!visited[x.v]) {
						visited[x.v] = true;
						que.add(x.v);
					}
				}
			}
			for (int j = 0; j < visited.length; j++)
				if (!visited[j])
					return false;
		}
		return true;
	}

	/** 3. Articulation Points (or Cut Vertices) in a Graph **/
	@Override // TODO unable to understand
	public List<Integer> articulationPoints(Graph<Integer, Integer> g) {

		return null;
	}

	/** 4. Biconnected graph **/
	public boolean isCycleFromVertex(Graph<Integer, Integer> g, Integer v) {

		boolean visited[] = new boolean[g.vSize];
		int currentParent[] = new int[g.vSize];
		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		visited[v] = true;
		while (!que.isEmpty()) {
			int par = que.poll();
			GLNode<Integer, Integer> gn = g.gl[par];
			for (; gn != null; gn = gn.next) {
				currentParent[gn.v] = par;
				if (v.equals(gn.v) && currentParent[par] != gn.v)
					return true;
				if (!visited[gn.v]) {
					visited[gn.v] = true;
					que.add(gn.v);
				}
			}
		}
		return false;
	}

	// it must make cicyle from all vertex if v.size>2
	@Override
	public boolean isBiconnected(Graph<Integer, Integer> g) {

		if (g.vSize > 2) {
			for (int i = 0; i < g.vSize; i++) {
				if (!isCycleFromVertex(g, i))
					return false;
			}
			return true;
		} else {
			if (g.gl[0].next != null)// ie connected
				return true;
			else
				return false;
		}
	}

	/** 5. Bridges in a graph **/
	public List<Edge> bridges(Graph<Integer, Integer> g) {
		Set<Edge> set = new HashSet<>();
		List<Edge> list = null;
		List<Edge> rList = new ArrayList<>();

		// collect all the edges
		for (int i = 0; i < g.vSize; i++) {
			GLNode<Integer, Integer> x = g.gl[i];
			if (x != null) {
				for (; x != null; x = x.next)
					set.add(new Edge(i, x.v, 0));
			}
		}
		list = new ArrayList<>(set);
		// find the degde due to disconnection graph become non Bidirecton
		for (Edge e : list) {
			g = igu.deleteEdge(g, e.src, e.dest);
			if (!igu.isConnected(g, e.src))
				rList.add(e);
			g = igu.addEdgeUnDir(g, e.src, e.dest);
		}
		return rList;
	}

	/** 6. Eulerian path and circuit **/
	/* Eulerian path */
	@Override
	public List<Integer> eulerianPath(Graph<Integer, Integer> g, Integer src) {

		List<Integer> list = new ArrayList<>();
		if (igu.isConnected(g, src)) {
			boolean visited[] = new boolean[g.vSize];
			Queue<Integer> que = new LinkedList<>();
			que.add(src);
			visited[src] = true;
			list.add(src);
			while (!que.isEmpty()) {
				int par = que.poll();

				GLNode<Integer, Integer> gn = g.gl[par];
				for (; gn != null; gn = gn.next) {
					if (!visited[gn.v]) {
						list.add(gn.v);
						visited[gn.v] = true;
						que.add(gn.v);
					}
				}
			}
		}
		return list;
	}

	/* Eulerian circuit */
	@Override
	public boolean eulerianCircuit(Graph<Integer, Integer> g) {

		// Check if all non-zero degree vertices are connected
		if (!igu.isConnected(g, 0))
			return false;

		// Count vertices with odd degree
		int odd = 0;
		for (int i = 0; i < g.vSize; i++)
			if (igu.degree(g, i) % 2 != 0)
				odd++;

		// If count is more than 2, then graph is not Eulerian
		if (odd > 2)
			return false;

		// If odd count is 2, then semi-eulerian.
		// If odd count is 0, then eulerian
		// Note that odd count can never be 1 for undirected graph
		return (odd == 0) ? true : false;
	}

	public boolean isAllVisited(boolean visited[]) {
		for (int i = 0; i < visited.length; i++)
			if (!visited[i])
				return false;
		return true;
	}
}
