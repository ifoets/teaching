package com.design.analysis.advance.simple.example.behavioral.chainofresponsibility;

import java.net.StandardSocketOptions;

public class ErrorLogger extends Logger{

    public ErrorLogger(int levels)
    {
        this.levels = levels;
    }
    @Override
    protected void displayLogInfo(String message) {
        System.out.println("ERROR INFO "+message);
    }
}
