package ru.nsu.kurgin.lab3.sudoku.time;

import ru.nsu.kurgin.lab3.sudoku.TimerObserver.TimerObservable;

public class MyTimer extends TimerObservable implements Runnable {
    private boolean isActive = true;

    public void setActive(boolean active) {
        System.out.println("rabotaet");
        isActive = active;
    }

    public Integer getSeconds() {
        return seconds;
    }

    private Integer seconds = 0;

    public void run()        //Этот метод будет выполняться в побочном потоке
    {
        while (isActive) {
            notifyTimeObservers(seconds);
            System.out.println(seconds);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds++;
        }
    }
}
