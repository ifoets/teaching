package com.design.analysis.advance.simple.example.behavioral.command;

public class CommandPattern {

    FileOperationExecute executer;

    public  CommandPattern(FileOperationExecute executer)
    {
        this.executer = executer;
    }
    public void executeCommand(FileOperation operation)
    {
        executer.executeOperation(operation);
    }

    public void executeAllCommand()
    {
        executer.executeAllOperation();
    }
}
