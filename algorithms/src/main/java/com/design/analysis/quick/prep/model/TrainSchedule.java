package com.design.analysis.quick.prep.model;

import java.util.Comparator;

public class TrainSchedule  {
   public int arrivalTime, deptTime;
    public TrainSchedule(int arrivalTime, int deptTime)
    {
        this.arrivalTime = arrivalTime;
        this.deptTime = deptTime;
    }
    public String toString()
    {
        return "(" + this.arrivalTime + ","
                + this.deptTime + ")";
    }
}
