package ru.nsu.lab1.Kurgin;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scanner {
    private Map<String, Integer> mapWorld = new HashMap<>();
    private int countWorld;

    public int getCountWorld() {
        return countWorld;
    }

    public void ScanString(String str) {
        Pattern pattern = Pattern.compile(Constants.Regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            countWorld++;
            mapWorld.merge(str.substring(matcher.start(), matcher.end()), 1, Integer::sum);
        }
    }

    public List<Map.Entry<String, Integer>> getListWords() {
        List<Map.Entry<String, Integer>> listWords = new ArrayList<>(mapWorld.entrySet());
        listWords.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int dif = o1.getValue() - o2.getValue();
                return Integer.compare(0, dif);
            }
        });
        return listWords;
    }
}
