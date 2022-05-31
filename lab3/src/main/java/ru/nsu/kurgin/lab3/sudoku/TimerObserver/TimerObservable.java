package ru.nsu.kurgin.lab3.sudoku.TimerObserver;

import java.util.ArrayList;
import java.util.List;

public class TimerObservable {

    List<TimerObserver> list = new ArrayList<>();

    public void addObserver(TimerObserver observer) {
        list.add(observer);
    }

    public void removeObserver(TimerObserver observer) {
        list.remove(observer);
    }

    public void notifyTimeObservers(Integer seconds) {
        for (TimerObserver ob : list) {
            ob.timerUpdate(seconds);
        }
    }
}

