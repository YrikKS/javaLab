package ru.nsu.lab1.Kurgin;

import java.io.*;
import java.security.KeyPair;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Writer implements AutoCloseable {
    private BufferedWriter bufWriter;

    Writer() {

    }

    private void checkNameFileOut(String nameFile) {
        try {
            Pattern pattern = Pattern.compile(Constants.RegexFileNameOut);
            Matcher matcher = pattern.matcher(nameFile);
            if (!matcher.find()) {
                throw (new AnalyzerExeption(Constants.ErrorNameFile));
            }
        } catch (AnalyzerExeption exeption) {
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

    public void writeList(List<Map.Entry<String, Integer>> list, int counterWords) throws IOException {
        for (Map.Entry<String, Integer> element : list) {
            bufWriter.write(element.getKey() + " ; " + element.getValue().toString() + " ; "
                    + String.valueOf(element.getValue().floatValue() / counterWords * 100) + '\n');
        }
    }

    @Override
    public void close() throws Exception {
        bufWriter.close();
    }
}

