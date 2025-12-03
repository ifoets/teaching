package com.design.analysis.ds.graph.hard;

import javax.management.Query;
import java.util.*;
import java.util.stream.Collectors;

public class GraphHardImpl implements IGraphHard{

    /**269 — Alien Dictionary**/
    public String alienOrder(String[] words){

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        for(String word:words)
        {
            for(Character ch:word.toCharArray())
            {
                graph.putIfAbsent(ch,new HashSet<>());
                indegree.putIfAbsent(ch,0);
            }
        }

        // Build edges by comparing adjacent words
        for(int i=0;i<words.length-1;i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            // Invalid case: prefix problem
            if (w1.length() > w2.length() && w1.startsWith(w2))
                return "";

            int minLen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;  // stop after the first mismatch
                }
            }
        }
            Queue<Character> queue = new ArrayDeque<>();
            for(char c:indegree.keySet())
            {
                if(indegree.get(c)==0)
                    queue.offer(c);
            }

            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty())
            {
                char c = queue.poll();
                sb.append(c);
                for(Character next:graph.get(c))
                {
                    indegree.put(next,indegree.get(next)-1);
                    if(indegree.get(next)==0)
                        queue.offer(next);
                }
            }
        // If not all characters are included → cycle
        if (sb.length() != indegree.size()) return "";

        return sb.toString();
    }

    /**329. Longest Increasing Path in a Matrix**/
    @Override
    public int longestIncreasingPath(int[][]mat){

        int R = mat.length;
        int C = mat[0].length;
        int[][] indegree = new int[R][C];
        int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<R;i++)
        {
            for (int j=0;j<C;j++)
            {
               for (int[]dr:dirs)
               {
                   int x = i+dr[0];
                   int y = j+dr[1];
                   if(x>=0&&x<R && y>=0&&y<C && mat[x][y]>mat[i][j])
                       indegree[x][y]++;
               }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(indegree[i][j]==0)queue.offer(new int[]{i,j});

        int LIS=0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                int[] node = queue.poll();
                assert node != null;
                int r = node[0];
                int c = node[1];

                for(int[] d:dirs)
                {
                    int xr = r+d[0];
                    int yc = c+d[1];
                    if(xr>=0&&xr<R && yc>=0&& yc<C && mat[xr][yc]>mat[r][c])
                    {
                        if(--indegree[xr][yc]==0)
                            queue.offer(new int[]{xr,yc});
                    }
                }
            }
            LIS++;
        }
    return LIS;
    }

    /**332. Reconstruct Itinerary, it is one of lex order first in find the all path**/
    @Override
    public List<String> findItinerary(List<List<String>> tickets){
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets)
            graph.computeIfAbsent(ticket.get(0), k-> new PriorityQueue<>()).add(ticket.get(1));

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);//begin with "JFK" is in question

        return itinerary;
    }
    private void dfs(String airport, Map<String,PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> pq = graph.getOrDefault(airport, new PriorityQueue<>());

        while (!pq.isEmpty()) {
            String next = pq.poll();
            dfs(next,graph, itinerary);
        }
        // Add when outgoing edges are finished ie adding during start completing is from call last to first
        itinerary.addFirst(airport);
    }
}
