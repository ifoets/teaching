package com.design.analysis.core.algo.starpatterns;

public interface IStarPatterns {

    /** 1. print left bottom 90 degree triangle
     *
     * *
     * * *
     * * * *
     * * * * *
     * * * * * *
     * * * * * * *
     * */
     int leftBottom90Triangle(int n);

    /**
     *
     *
     *
     *
     *
     *
     * * * * * * *
     */
     int leftBottom90LPrint(int n);

    /**
     *
       *
         *
           *
             *
               *
                 *
     */
     int leftTopToRightBottomDiagonal(int n);

     /**
      *
      * *
      *   *
      *     *
      *       *
      *         *
      * * * * * * *
      */
    int leftBottom90EmptyTriangle(int n);

    /** 2. print left up 90 degree triangle
     * * * * * * *
       * * * * * *
         * * * * *
           * * * *
             * * *
               * *
                 *
     * */
     int rightTop90Triangle(int n);

     /**
      * * * * * * *
                  *
                  *
                  *
                  *
                  *
                  *
      */
    int rightTop90LTriangle(int n);

    int rightTop90EmptyTriangle(int n);


    /** 3. print right up 90 degree triangle*/
     int rightUpTriangle(int n);


    /**
     * * * * * * *
     *         *
     *       *
     *     *
     *   *
     * *
     *
     */
    int rightTopToLeftBottomEmptyTriangle(int n);

    int rightTopToLetBottomDiagonal(int n);

    /** 4. print right up 90 degree triangle
                 *
               * *
             * * *
           * * * *
         * * * * *
       * * * * * *
     * * * * * * *
     * */
     int rightDownTriangle(int n);

     /** 5. print temple TOP UP
                    *
                 *  *  *
              *  *  *  *  *
           *  *  *  *  *  *  *
        *  *  *  *  *  *  *  *  *
     *  *  *  *  *  *  *  *  *  *  *
  *  *  *  *  *  *  *  *  *  *  *  *  *
      *  */
     int printTempleTopUp(int n);

     /**6 print temple TOP RIGHT
      *
      *  *
      *  *  *
      *  *  *  *
      *  *  *  *  *
      *  *  *  *  *  *
      *  *  *  *  *  *  *
      *  *  *  *  *  *
      *  *  *  *  *
      *  *  *  *
      *  *  *
      *  *
      *
      * */
    int printTempleTopRight(int n);

    /**7 print temple TOP DOWN
 *  *  *  *  *  *  *  *  *  *  *  *  *
    *  *  *  *  *  *  *  *  *  *  *
       *  *  *  *  *  *  *  *  *
          *  *  *  *  *  *  *
             *  *  *  *  *
                *  *  *
                   *
     * */
    int printTempleTopDown(int n);

    /**8 print temple TOP LEFT
                  *
                *  *
             *  *  *
          *  *  *  *
       *  *  *  *  *
    *  *  *  *  *  *
 *  *  *  *  *  *  *
    *  *  *  *  *  *
       *  *  *  *  *
          *  *  *  *
             *  *  *
                *  *
                   *
     * */
    int printTempleTopLeft(int n);

    /**9 print top down dumbbell
     *  *  *  *  *  *  *  *  *  *  *  *  *
        *  *  *  *  *  *  *  *  *  *  *
           *  *  *  *  *  *  *  *  *
              *  *  *  *  *  *  *
                 *  *  *  *  *
                    *  *  *
                       *
                       *
                    *  *  *
                 *  *  *  *  *
              *  *  *  *  *  *  *
            *  *  *  *  *  *  *  *  *
         *  *  *  *  *  *  *  *  *  *  *
      *  *  *  *  *  *  *  *  *  *  *  *  *
     * */

    int printUpDownDumbbell (int n);


    /**10 print butter fly
     *                          *
     *  *                    *  *
     *  *  *              *  *  *
     *  *  *  *        *  *  *  *
     *  *  *  *  *  *  *  *  *  *
     *  *  *  *        *  *  *  *
     *  *  *              *  *  *
     *  *                    *  *
     *                          *
    */
    int printButterFly(int n);

    int printSwasticSymbol(int n);

    int printSquareWithDiagonal(int n);

}
