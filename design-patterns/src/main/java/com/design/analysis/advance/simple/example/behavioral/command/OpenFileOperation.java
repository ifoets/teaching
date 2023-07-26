package com.design.analysis.advance.simple.example.behavioral.command;

public class OpenFileOperation implements  FileOperation{

    private TextFile file;

    public OpenFileOperation(TextFile file)
    {
        this.file = file;
    }

    public TextFile getFile() {
        return file;
    }
    @Override
    public void execute()
    {
        file.open();
    }

}
