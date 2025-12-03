package com.design.analysis.ds.graph.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IHardGraphTest {

    IGraphHard igh;

    @Before
    public void init()
    {
        igh = new GraphHardImpl();
    }

    /**269 — Alien Dictionary**/
    @Test
    public void alienOrderTest()
    {
        String [] alienWordsLexSortedOrder = {"wrt","wrf","er","ett","rftt"};
        Assert.assertEquals("wertf",igh.alienOrder(alienWordsLexSortedOrder));
    }

    /**329. Longest Increasing Path in a Matrix**/
    @Test
    public void longestIncreasingPathTest()
    {
        //[[3,4,5],[3,2,6],[2,2,1]]
       int[][] matrix = {
          /* {9,9,4},
           {6,6,8},
           {2,1,1}*/
           {3,4,5},
           {3,2,6},
           {2,2,1}
       };
        System.out.println(igh.longestIncreasingPath(matrix));
    }

    /**332. Reconstruct Itinerary, it is one of lex order first in find the all path**/
    @Test
    public void findItineraryTest()
    {
         List<List<String>> tickets = List.of(
            List.of("MUC","LHR"),
            List.of("JFK","MUC"),
            List.of("SFO","SJC"),
            List.of("LHR","SFO")
        );
        //List<String> result = igh.findItinerary(tickets);
        List<String> expResult = List.of("JFK", "MUC", "LHR", "SFO", "SJC");
        //Assert.assertEquals(expResult,result);

        List<List<String>> tickets1 = List.of(
            List.of("JFK","SFO"),
            List.of("JFK","ATL"),
            List.of("SFO","ATL"),
            List.of("ATL","JFK"),
            List.of("ATL","SFO")
        );
        //"JFK","ATL","JFK","SFO","ATL","SFO
        List<String> result1 = igh.findItinerary(tickets1);
        System.out.println(result1.toString());
        //List<String> expResult1 = List.of("JFK","ATL","JFK","SFO","ATL","SFO");
        //Assert.assertEquals(expResult1,result1);
    }
}
