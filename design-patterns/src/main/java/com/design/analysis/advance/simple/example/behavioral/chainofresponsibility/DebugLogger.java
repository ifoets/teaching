package com.design.analysis.advance.simple.example.behavioral.chainofresponsibility;

public class DebugLogger extends Logger{

    public DebugLogger(int levels)
    {
        this.levels = levels;
    }
    @Override
    protected void displayLogInfo(String message) {
        System.out.println("DEBUG INFO: "+message);
    }
}
