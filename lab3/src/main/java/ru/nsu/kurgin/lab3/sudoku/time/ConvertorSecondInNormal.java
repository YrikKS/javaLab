package ru.nsu.kurgin.lab3.sudoku.time;

import ru.nsu.kurgin.lab3.sudoku.Constants;

public class ConvertorSecondInNormal {
    static public String convertSecond(Integer seconds) {
        int sec = seconds % Constants.SECONDS_PER_MINUTE;
        int min = seconds / Constants.SECONDS_PER_MINUTE;
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
