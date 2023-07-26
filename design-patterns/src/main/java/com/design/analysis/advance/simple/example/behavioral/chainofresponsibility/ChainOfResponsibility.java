package com.design.analysis.advance.simple.example.behavioral.chainofresponsibility;

import java.util.Arrays;

public class ChainOfResponsibility {

    public Logger doChanning(int ...levels)
    {
        Logger logger = null;
        int lev[] = Arrays.stream(levels).toArray();
        int i=0;
        while (i<lev.length)
        {
            switch (i)
            {
                case 1:
                    if(logger==null)
                        logger = new ConsoleLogger(Logger.CONSOLE_INFO);
                    else logger.setNextLogger(new ConsoleLogger(ConsoleLogger.CONSOLE_INFO));
                    break;
                case 2:
                    if(logger ==null)
                        logger = new ErrorLogger(Logger.ERROR_INFO);
                    else logger.setNextLogger(new ErrorLogger(Logger.ERROR_INFO));
                    break;
                case 3:
                    if(logger ==null)
                        logger = new DebugLogger(Logger.DEBUG_INFO);
                    else logger.setNextLogger(new DebugLogger(Logger.DEBUG_INFO));
            }
            i++;
        }
        return logger;
    }
}
