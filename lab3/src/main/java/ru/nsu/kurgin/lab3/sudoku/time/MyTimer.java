package ru.nsu.kurgin.lab3.sudoku.time;

import ru.nsu.kurgin.lab3.sudoku.TimerObserver.TimerObservable;

public class MyTimer extends TimerObservable implements Runnable {
    private Integer seconds = 0;
    private boolean isActive = true;

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void run() {
        while (isActive) {
            notifyTimeObservers(seconds);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds++;
        }
    }
}
