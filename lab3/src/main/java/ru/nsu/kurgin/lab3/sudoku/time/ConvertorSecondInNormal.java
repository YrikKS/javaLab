package ru.nsu.kurgin.lab3.sudoku.time;

public class ConvertorSecondInNormal {
    static public String convertSecond(Integer seconds) {
        int sec = seconds % 60;
        int min = seconds / 60;
        String time;
        if (min < 10)
            time = "0" + min;
        else {
            time = String.valueOf(min);
        }
        time = time + ":";

        if (sec < 10) {
            time = time + "0" + sec;
        } else
            time = time + sec;
        return time;
    }

    static public String convertSecond(String seconds) {
        return ConvertorSecondInNormal.convertSecond(Integer.parseInt(seconds));
    }
}
