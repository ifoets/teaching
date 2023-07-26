package com.design.analysis.advance.simple.example.behavioral.chainofresponsibility;

public abstract class Logger {
    public static int CONSOLE_INFO=1;
    public static  int ERROR_INFO=2;
    public static int DEBUG_INFO=3;
    public int levels;
    Logger nextLogger;
    public void setNextLogger(Logger logger)
    {
        this.nextLogger = logger;
    }
    public  void logMessage(int levels, String message)
    {
        if(this.levels<=levels)
            displayLogInfo(message);
        if(nextLogger!=null)
            nextLogger.logMessage(levels,message);
    }
protected abstract void displayLogInfo(String message);
}
