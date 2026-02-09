package com.design.analysis.algo.shortest.path.medium;

import java.util.List;

public interface IShortestPathMedium {

    /**399. Evaluate Division**/
     double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries);

     /**743. Network Delay Time**/
     int networkDelayTime(int[][] times, int n, int k);

     /**787. Cheapest Flights Within K Stops**/
     int findCheapestPrice(int n, int[][] flights, int src, int dst, int k);
}
