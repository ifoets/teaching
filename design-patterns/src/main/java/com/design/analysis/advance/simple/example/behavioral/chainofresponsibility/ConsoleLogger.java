package com.design.analysis.advance.simple.example.behavioral.chainofresponsibility;

public class ConsoleLogger extends Logger{

    public ConsoleLogger(int levels)
    {
        this.levels = levels;
    }
    @Override
    protected void displayLogInfo(String message) {
        System.out.println("CONSOLE INFO :"+message);
    }
}
