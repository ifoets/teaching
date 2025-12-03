package com.design.analysis.ds.graph.medium;

import com.design.analysis.ds.graph.node.GNode;

import java.util.*;

public class GraphMediumImpl implements IGraphMedium<Integer>{

    /**133. Clone Graph**/
    @Override
    public GNode<Integer> cloneGraph(GNode<Integer> node){
        if(node==null)
            return null;

        Queue<GNode<Integer>> queue = new LinkedList<>();
        Map<Integer, GNode<Integer>> map = new HashMap<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            GNode<Integer> curr = queue.poll();
            GNode<Integer> clone  = new GNode<>(curr.val);
            map.put(clone.val,curr);
            List<GNode<Integer>> neighbours = curr.neighbours;
            for (GNode<Integer> gnode : neighbours) {
                map.put(gnode.val,gnode);
                if(!map.containsKey(gnode.val)) {
                    queue.add(gnode);
                }
                clone.neighbours.add(map.get(gnode.val));
            }
        }
        return map.get(node.val);
    }

    @SuppressWarnings("unchecked")
    @Override
    public GNode<Integer> cloneGraphX(GNode<Integer> node){
        if(Objects.isNull(node))
            return null;

        GNode<Integer>[] map =  new GNode[101];
        Deque<GNode<Integer>> stack = new ArrayDeque<>();
        stack.push(node);
        map[node.val] = new GNode<>(node.val);

        while (!stack.isEmpty())
        {
            GNode<Integer> cur = stack.pop();
            GNode<Integer> curClone = map[cur.val];

            for(GNode<Integer> neigh:cur.neighbours)
            {
                if(map[neigh.val]==null) {
                    map[neigh.val] = new GNode<>(neigh.val);
                    stack.push(neigh);
                }
                //connect graph
                curClone.neighbours.add(map[neigh.val]);
            }
        }
    return map[node.val];
    }

    /**207. Course Schedule**/
    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites){

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++)graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for(int[] p:prerequisites)
        {
            int a = p[0];
            int b = p[1];
            graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // Add all courses with no prerequisites
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)queue.add(indegree[i]);
        }
        int count=0;
        while (!queue.isEmpty())
        {
            int course = queue.poll();
            count++;
            for(int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[course] == 0)
                    queue.add(next);
            }
        }
        // If we processed all courses, no cycle exists
        return count==numCourses;
    }

    /**210. Course Schedule II**/
    @Override
    public int[] findOrder(int numCourses, int[][] prerequisites){

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());

        int [] indegree = new int[numCourses];
        for(int[] p:prerequisites)
        {
            int a = p[0];
            int b = p[1];
            graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        //collect indegree 0 ie not prerequisites ie independent
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)queue.add(indegree[i]);
        }
        int [] order = new int[numCourses];
        int idx=0;
        while (!queue.isEmpty())
        {
            int node = queue.poll();
            order[idx++]=node;
            for(int next: graph.get(node))
            {
                indegree[next]--;
                if(indegree[next]==0)queue.add(next);
            }
        }
        return idx==numCourses? order: new int[0];
    }

    @Override
    public boolean validTree(int n, int[][] edges){

        // Quick check: a tree must have exactly n-1 edges
        if(edges.length!=n-1)return  false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int[] edge:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(0,graph,visited);
        for(boolean visit:visited)
        {
            if(!visit)return false;
        }
        return true;
    }
    private void dfs(int node,List<List<Integer>> graph, boolean[] visited)
    {
        visited[node]=true;
        for (int nNode:graph.get(node))
        {
            if(!visited[nNode])
                dfs(nNode,graph,visited);
        }
    }

    /**277. Find the Celebrity**/
    @Override
    public int celebrity(int n, int[][]knows){

         Map<Integer,Set<Integer>> graph = new HashMap<>();
         for(int i=0;i<n;i++) graph.putIfAbsent(i,new HashSet<>());

         for(int[]know:knows) graph.get(know[0]).add(know[1]);

         for(int i=0;i<n;i++)
         {
             int count=0;
             if(graph.get(0).isEmpty())
             {
                 for(int j=i;j<n;j++)
                 {
                     if(i!=j && graph.get(j).contains(i))
                     {
                         count++;
                     }
                 }
                 if(count==n-1)
                     return i;
             }
         }
         return -1;
    }

    /**310. Minimum Height Trees, find the center of tree **/
    @Override
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        if(n==1) return Collections.singletonList(0);
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++)  graph.putIfAbsent(i,new HashSet<>());
        int[] indegree = new int[n];
        for(int[]edge:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==1)queue.add(i); //add leaf node
        }
        int proceed=0;
        while (n-proceed>2)
        {
            int size = queue.size();
            proceed+=size;
            for(int i=0;i<size;i++)
            {
                int poll = !queue.isEmpty()?queue.poll():n+1;
                for(int next:graph.get(poll))
                {
                    if(--indegree[next]==1)
                        queue.add(next);
                }
            }
        }
       return new LinkedList<>(queue);
    }

    /**323. Number of Connected Components in an Undirected Graph**/
    @Override
    public List<Set<Integer>> disjointSet(int n,int[][]edges){

        Map<Integer,Set<Integer>> graph = new LinkedHashMap<>();

        for(int i=0;i<n;i++)graph.put(i, new HashSet<>());
        for(int[] e:edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        List<Set<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                Set<Integer> set = new HashSet<>();
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    visited[node] = true;
                    set.add(node);
                    for (int next : graph.get(node))
                        if (!visited[next]) queue.add(next);
                }
                result.add(set);
            }
        }
        return result;
    }

    /**399. Evaluate Division**/
    @Override
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        return null;
    }
}
