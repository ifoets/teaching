package com.design.analysis.ds.graph.hard;

import java.util.List;

public interface IGraphHard {

    /**269 — Alien Dictionary**/
    String alienOrder(String[] words);

    /**329. Longest Increasing Path in a Matrix**/
    int longestIncreasingPath(int[][]matrix);

    /**332. Reconstruct Itinerary, it is one of lex order first in find the all path**/
    List<String> findItinerary(List<List<String>> tickets);
}
