package com.company.Readers;

import com.company.Exeptions.CommandExceptions;

import java.io.IOException;
import java.util.Scanner;

public class ReaderFromCmd implements Reader {
    Scanner in = null;

    ReaderFromCmd() {
        in = new Scanner(System.in);
    }

    @Override
    public Command getCommand() throws IOException, CommandExceptions {
        return new Command(in.nextLine());
    }

    @Override
    public void closeInputStream() throws IOException {
        in.close();
    }
}
