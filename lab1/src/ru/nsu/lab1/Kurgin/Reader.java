package ru.nsu.lab1.Kurgin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Reader implements AutoCloseable {
    private BufferedReader bufReader;

    Reader() {

    }

    private void checkNameFileIn(String nameFile) {
        try {
            Pattern pattern = Pattern.compile(Constants.RegexFileNameIn);
            Matcher matcher = pattern.matcher(nameFile);
            if (!matcher.find()) {
                throw (new AnalyzerExeption(Constants.ErrorNameFile));
            }
        } catch (AnalyzerExeption exeption) {
            exeption.printStackTrace();
        }
    }

    public void openFileIn(String fileName) {
        checkNameFileIn(fileName);
        try {
            bufReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readStr() {
        try {
            return bufReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        bufReader.close();
    }
}
