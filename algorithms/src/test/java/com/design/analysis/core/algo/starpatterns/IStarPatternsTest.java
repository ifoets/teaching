package com.design.analysis.core.algo.starpatterns;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.out;

public class IStarPatternsTest {

    public IStarPatterns isp;

    @Before
    public void inti()
    {
        isp = new StarPatternsImpl();
    }

    /** 1. print left bottom 90 degree triangle*/
    @Test
    public void leftBottomTriangleTest()
    {
        Assert.assertEquals(55,isp.leftBottom90Triangle(10));
    }
    @Test
    public void leftBottomLPrintTest()
    {
        Assert.assertEquals(19,isp.leftBottom90LPrint(10));
    }
    @Test
    public void leftTopToRightBottomDiagonalTest(){
        Assert.assertEquals(10,isp.leftTopToRightBottomDiagonal(10));

    }
    @Test
    public void leftTopToRightBottomEmptyTriangleTest()
    {
        Assert.assertEquals(27,isp.leftBottom90EmptyTriangle(10));
    }
    /** 2. print right up 90 degree triangle*/
    @Test
    public void rightUpTriangleTest()
    {
        Assert.assertEquals(55,isp.rightTop90Triangle(10));
    }

    @Test
    public void rightUpLPrintTest(){
        Assert.assertEquals(19,isp.rightTop90LTriangle(10));
    }

    @Test
    public void rightTop90EmptyTriangleTest(){
        Assert.assertEquals(27,isp.rightTop90EmptyTriangle(10));
    }

    /** 3. print right up 90 degree triangle*/
    @Test
    public void leftUpTriangleTest(){
        isp.rightTop90Triangle(7);
        Assert.assertEquals(55,isp.rightTop90Triangle(10));
    }
    @Test
    public void rightTopToLeftBottomEmptyTriangleTest()
    {
        Assert.assertEquals(27,isp.rightTopToLeftBottomEmptyTriangle(10));
    }

    @Test
    public void rightTopToLetBottomDiagonalTest(){
        Assert.assertEquals(10,isp.rightTopToLetBottomDiagonal(10));

    }

    /** 4. print right down 90 degree triangle*/
    @Test
    public void rightDownTriangleTest()
    {
        Assert.assertEquals(55,isp.rightDownTriangle(10));
    }

    /** 5. print temple*/
    @Test
    public void printTempleTopUpTest()
    {
        Assert.assertEquals(100,isp.printTempleTopUp(10));
    }

    /** print temple TOP RIGHT */
    @Test
    public void printTempleTopRightTest()
    {
        Assert.assertEquals(100,isp.printTempleTopRight(10));
    }

    /**6 print temple TOP DOWN */
    @Test
    public void printTempleTopDownTest()
    {
        Assert.assertEquals(100,isp.printTempleTopDown(10));
    }

    /**7 print temple TOP LEFT*/
    @Test
    public void printTempleTopLeftTest()
    {
        Assert.assertEquals(100,isp.printTempleTopLeft(10));
    };

    /**9 print top down dumbbell*/

    @Test
    public void printUpDownDumbbellTest()
    {
        Assert.assertEquals(200,isp.printUpDownDumbbell(20));
    }

    /**10 print butter fly*/
    @Test
    public void printButterFlyTest(){
        Assert.assertEquals(200,isp.printButterFly
            (20));
    }

    @Test
    public void printSwasticSymbolTest()
    {
        Assert.assertEquals(81, isp.printSwasticSymbol
            (21));
    }

    @Test
    public void printSquareWithDiagonalTest()
    {
        Assert.assertEquals(117, isp.printSquareWithDiagonal(21));
    }
}
