package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Reader {
    private BufferedReader bufReader;

    Reader() {

    }

    private void checkNameFileIn(String nameFile) {
        try {
            Pattern pattern = Pattern.compile(Constants.RegexFileNameIn);
            Matcher matcher = pattern.matcher(nameFile);
            if (!matcher.find()) {
                throw (new MyExeption(Constants.ErrorNameFile));
            }
        } catch (MyExeption exeption) {
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

    public void closeFileIn() {
        try {
            bufReader.close();
        } catch (IOException e) {
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

}
