package com.design.analysis.algo.shortest.path.medium;

import java.util.*;

public class ShortestPathMediumImpl implements IShortestPathMedium{

    /**399. Evaluate Division**/
    @Override
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){

        Map<String,Map<String,Double>> graph = new HashMap<>();
        double[] result = new double[queries.size()];

        for(int i=0;i<equations.size();i++)
        {
            String a = equations.get(i).getFirst();
            String b = equations.get(i).getLast();
            double val = values[i];

            graph.computeIfAbsent(a, k->new HashMap<>()).put(b,val);
            graph.computeIfAbsent(b,k->new HashMap<>()).put(a,1/val);
        }

        for(int i=0;i<queries.size();i++)
        {
            String src = queries.get(i).getFirst();
            String dest= queries.get(i).getLast();

            if(!graph.containsKey(src) || !graph.containsKey(dest))
                result[i]=-1.0;
            else if(src.equals(dest))
                result[i]=1.0;
            else result[i]=dfsCalcEquation(src,dest,1.0,new HashSet<>(),graph);
        }
        return result;
    }
    private double dfsCalcEquation(String curr,String target, double product, Set<String> visited,Map<String,Map<String,Double>> graph)
    {
        if(curr.equals(target))
            return product;
        visited.add(curr);

        for (Map.Entry<String,Double> next:graph.get(curr).entrySet())
        {
            if(!visited.contains(next.getKey()))
            {
                double dfs = dfsCalcEquation(next.getKey(),target,product*next.getValue(),visited,graph);
                if(dfs!=-1.0) return dfs;
            }
        }
        return -1.0;
    }

    /**743. Network Delay Time**/
    @Override
    public int networkDelayTime(int[][] times, int n, int k){

        Map<Integer,List<int[]>> graph = new HashMap<>();
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        for (int[] t : times) {
            graph.computeIfAbsent(t[0], x -> new ArrayList<>())
                .add(new int[]{t[1], t[2]});
        }
     PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[0]));
        pq.offer(new int[]{0,k});
        while (!pq.isEmpty())
        {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];
            if(dist[node]<time) continue;

            for(int[] ne:graph.getOrDefault(node,List.of()))
            {
                int next=ne[0];
                int wt = ne[1];
                if(dist[next]>time+wt)
                {
                    dist[next]=time+wt;
                    pq.offer(new int[]{dist[next],next});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
    /**787. Cheapest Flights Within K Stops**/
    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], x -> new ArrayList<>())
                .add(new int[]{f[1], f[2]});
        }

        // best[node][flightsUsed]
        int[][] best = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{0, src, 0}); // cost, node, flightsUsed
        best[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], node = cur[1], flightsUsed = cur[2];

            if (node == dst) return cost;
            if (flightsUsed == k + 1) continue;

            for (int[] nei : graph.getOrDefault(node, List.of())) {
                int next = nei[0], price = nei[1];
                int newCost = cost + price;

                if (newCost < best[next][flightsUsed + 1]) {
                    best[next][flightsUsed + 1] = newCost;
                    pq.offer(new int[]{newCost, next, flightsUsed + 1});
                }
            }
        }

        return -1;
    }
}
