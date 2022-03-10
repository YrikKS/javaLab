package com.company;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.Constants.*;

public class Writer {
    private BufferedWriter bufWriter;

    Writer() {

    }

    private void checkNameFileOut(String nameFile) {
        try {
            Pattern pattern = Pattern.compile(RegexFileNameOut);
            Matcher matcher = pattern.matcher(nameFile);
            if (!matcher.find()) {
                throw(new MyExeption(ErrorNameFile));
            }
        }
        catch (MyExeption exeption) {
            exeption.printStackTrace();
        }
    }

    public void openFileOut(String fileName) {
        checkNameFileOut(fileName);
        try {
            bufWriter = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFileIn() {
        try {
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeList(List<Map.Entry<String, Integer>> list, int counterWords) throws IOException {
        for (Map.Entry<String, Integer> element : list) {
            bufWriter.write(element.getKey() + " ; " + element.getValue().toString() + " ; "
                    + String.valueOf(element.getValue().floatValue() / counterWords * 100) + '\n');
        }
    }
}

