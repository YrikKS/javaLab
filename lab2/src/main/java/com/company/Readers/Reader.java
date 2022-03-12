package com.company.Readers;

import com.company.Exeptions.CommandExceptions;

import java.io.IOException;

public interface Reader {
    public Command getCommand() throws IOException, CommandExceptions;
    public void closeInputStream() throws IOException;
}
