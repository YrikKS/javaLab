package ru.nsu.lab1.Kurgin;

public class Pair {
    String key;
    Integer value;

    public Pair(String str, Integer num) {
        key = str;
        value = num;
    }

    public Integer getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
