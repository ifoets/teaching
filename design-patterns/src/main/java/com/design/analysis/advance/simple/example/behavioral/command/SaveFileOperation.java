package com.design.analysis.advance.simple.example.behavioral.command;

public class SaveFileOperation implements  FileOperation{

    private TextFile file;

    public SaveFileOperation(TextFile textFile)
    {
        this.file = textFile;
    }

    @Override
    public void execute()
    {
        file.save();
    }
}
