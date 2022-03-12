package com.company.Readers;

import com.company.Constants;
import com.company.Exeptions.CommandExceptions;
import com.company.Exeptions.FileInException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderFromFile implements Reader {
    private BufferedReader reader = null;

    ReaderFromFile(String fileName) throws FileNotFoundException, FileInException {
        checkNameFileIn(fileName);
        reader = new BufferedReader(new FileReader(fileName));
    }

    private void checkNameFileIn(String nameFile) throws FileInException {
        try {
            Pattern pattern = Pattern.compile(Constants.REGEX_FILE_NAME_IN);
            Matcher matcher = pattern.matcher(nameFile);
            if (!matcher.find())
                throw (new FileInException(Constants.EXEPTION_FILE_NAME));
        } finally {
            return;
        }
    }

    @Override
    public Command getCommand() throws IOException, CommandExceptions {
        return new Command(reader.readLine());
    }

    @Override
    public void closeInputStream() throws IOException {
        reader.close();
    }
}
