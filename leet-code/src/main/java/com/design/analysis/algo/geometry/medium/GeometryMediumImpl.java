package com.design.analysis.algo.geometry.medium;

public class GeometryMediumImpl implements IGeometryMedium{

    /**223. Rectangle Area**/
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2){

        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        int left   = Math.max(ax1, bx1);
        int right  = Math.min(ax2, bx2);
        int bottom = Math.max(ay1, by1);
        int top    = Math.min(ay2, by2);

        int overlap =
            Math.max(0, right - left) *
                Math.max(0, top - bottom);

        return areaA + areaB - overlap;
    }
}
