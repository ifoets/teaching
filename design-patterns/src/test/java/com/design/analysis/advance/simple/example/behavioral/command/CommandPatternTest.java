package com.design.analysis.advance.simple.example.behavioral.command;

import org.junit.Before;
import org.junit.Test;

public class CommandPatternTest {

    CommandPattern commandPattern;
    FileOperationExecute execute;

    @Before
    public  void init()
    {
        execute = new FileOperationExecute();
        commandPattern = new CommandPattern(execute);
    }
    @Test
    public void setCommandPatternTest()
    {
        commandPattern.executeCommand(new OpenFileOperation(new TextFile("abc.text")));
        commandPattern.executeCommand(new SaveFileOperation(new TextFile("abc.text")));
        System.out.println("\nExecute all command together");
        commandPattern.executeAllCommand();
    }
}
