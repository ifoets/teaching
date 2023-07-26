package com.design.analysis.advance.simple.example.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class FileOperationExecute {

    List<FileOperation> fileOperationList = new ArrayList<>();

    public void executeOperation(FileOperation operation)
    {
        fileOperationList.add(operation);
        operation.execute();
    }
    public void executeAllOperation()
    {
        for(FileOperation operation:fileOperationList)
            operation.execute();
    }
}
