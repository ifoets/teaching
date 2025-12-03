package com.design.analysis.ds.graph.medium;

import com.design.analysis.ds.graph.node.GNode;
import com.design.analysis.ds.graph.utils.GUtils;
import com.design.analysis.ds.graph.utils.GVUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class IGraphMediumTest {

    IGraphMedium<Integer> igm;

    @Before
    public void init()
    {
        igm = new GraphMediumImpl();
    }

    @Test
    public void cloneGraphTest()
    {
        List<List<Integer>> adjList = List.of(
            List.of(2, 4), // Node 1 -> 2,4
            List.of(1, 3), // Node 2 -> 1,3
            List.of(2, 4), //Node 3->2,4
            List.of(1, 3)// Node 4 -> 1,3
        );
        GNode<Integer> graphNode = GUtils.createGraph(adjList).getFirst();
        GNode<Integer> clone = igm.cloneGraph(graphNode);
        GUtils.displayNodes(clone);
    }

    @Test
    public void cloneGraphXTest()
    {
        List<List<Integer>> adjList = List.of(
            List.of(2, 4), // Node 1 -> 2,4
            List.of(1, 3), // Node 2 -> 1,3
            List.of(2, 4), //Node 3->2,4
            List.of(1, 3)// Node 4 -> 1,3
        );

        GNode<Integer> graphNode = GUtils.createGraph(adjList).getFirst();
        GNode<Integer> clone = igm.cloneGraphX(graphNode);
        GUtils.displayNodes(clone);
    }

    /**207. Course Schedule**/
    @Test
    public void canFinishTest(){
        Assert.assertTrue(igm.canFinish(2, new int[][]{{1,0}}));                       // simple
        Assert.assertFalse(igm.canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));     // diamond
        Assert.assertTrue(igm.canFinish(1, new int[][]{}));                             // single course
        Assert.assertFalse(igm.canFinish(2, new int[][]{{0,1},{1,0}}));                 // cycle -> []
        Assert.assertFalse(igm.canFinish(5, new int[][]{{1,0},{2,0},{3,1},{3,2},{4,3}}));
    }

    /**210. Course Schedule II**/
    @Test
    public void findOrderTest(){
        Assert.assertArrayEquals(new int[]{0,1},igm.findOrder(2, new int[][]{{1,0}}));                       // simple
        Assert.assertArrayEquals(new int[]{0},igm.findOrder(1, new int[][]{}));                             // single course
        Assert.assertArrayEquals(new int[]{},igm.findOrder(2, new int[][]{{0,1},{1,0}}));                // cycle -> []
        Assert.assertArrayEquals(new int[]{0,1,2,3,4},igm.findOrder(5, new int[][]{{1,0},{2,0},{3,1},{3,2},{4,3}}));
        Assert.assertArrayEquals(new int[]{0,1,2,3},igm.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));

    }

    @Test
    public void validTreeTest()
    {
        Assert.assertTrue(igm.validTree(2, new int[][]{{1,0}}));                       // simple
        Assert.assertFalse(igm.validTree(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));     // diamond
        Assert.assertTrue(igm.validTree(1, new int[][]{}));                             // single course
        Assert.assertFalse(igm.validTree(2, new int[][]{{0,1},{1,0}}));                 // cycle -> []
        Assert.assertTrue(igm.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));
        Assert.assertTrue(igm.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));//tree view
        Assert.assertFalse(igm.validTree(5, new int[][]{{0,1},{0,2},{0,3},{2,3}}));//disconnected
    }

    /**277. Find the Celebrity**/
    @Test
    public void celebrityTest()
    {
        int[][] knows={
            {1,0},
            {1,3},
            {1,2},
            {2,0},
            {2,3},
            {3,0}
        };
        Assert.assertEquals(0,igm.celebrity(4,knows));
    }

    /**310. Minimum Height Trees**/
    @Test
    public void findMinHeightTreesTest()
    {
        int[][] eges0 =
            {
                {1,0},
                {1,2},
                {1,3}
            };
        List<Integer> rs0 = igm.findMinHeightTrees(4,eges0);
        System.out.println(rs0.toString());
        int[][] edges={
            {0,1},
            {1,2},
            {1,3}
        };
        Assert.assertEquals(1,igm.findMinHeightTrees(4,edges).getFirst().intValue());
        int[][] edges1={
            {3,0},
            {3,1},
            {3,2},
            {3,4},
            {5,4}
        };
        List<Integer> rs = igm.findMinHeightTrees(6,edges1);
        System.out.println(rs.toString());
    }

    /**323. Number of Connected Components in an Undirected Graph**/
    @Test
    public void disjointSetTest() {
        int[][] edges = {
            {0, 1},
            {0, 2}
        };
        List<Set<Integer>> result = igm.disjointSet(3, edges);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(Set.of(0, 1, 2), result.getFirst());

        int[][] edges1 =  {{0, 1}, {1, 2}, {2, 3}, {4, 5}};
        List<Set<Integer>> result1 = igm.disjointSet(6, edges1);
        Assert.assertEquals(2,result1.size());
        Assert.assertEquals(Set.of(0,1,2,3),result1.getFirst());
        Assert.assertEquals(Set.of(4,5),result1.getLast());
    }
}
