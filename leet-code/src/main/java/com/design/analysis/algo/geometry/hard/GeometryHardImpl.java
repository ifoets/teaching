package com.design.analysis.algo.geometry.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GeometryHardImpl implements IGeometryHard{

    /**149. Max Points on a Line**/
    @Override
    public int maxPoints(int[][] points){

        if(points==null) return 0;
        if(points.length==1)return 1;
        Map<Float,Integer> map;
        int infySlop=0;
        int n = points.length;
        int globalMax=0;
        for(int i=0;i<n;i++)
        {
            map = new HashMap<>();
            infySlop=0;
            for(int j=i+1;j<n;j++)
            {
                if(points[j][0]==points[i][0])
                    infySlop++;
                else {
                    float slop  =(float) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                    if(slop==-0.0)slop=(float) 0.0;//this is edge caes
                    map.merge( slop,1,Integer::sum);
                }
            }
            int currentMax = map.values().stream().max(Integer::compareTo).orElse(1);
            currentMax = Math.max(currentMax,infySlop);
            globalMax=Math.max(currentMax,globalMax);
        }
        return globalMax+1;
    }
}
