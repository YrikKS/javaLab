package ru.nsu.kurgin.lab3.sudoku.time;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.lab3.sudoku.ConstLoggerMsg;
import ru.nsu.kurgin.lab3.sudoku.Constants;
import ru.nsu.kurgin.lab3.sudoku.TimerObserver.TimerObservable;

public class MyTimer extends TimerObservable implements Runnable {
    private static final Logger logger = LogManager.getLogger(MyTimer.class);

    private Integer seconds = 0;
    private boolean isActive = true;

    public void setActive(boolean active) {
        logger.info(ConstLoggerMsg.LOGGER_STOP_TIMER);
        isActive = active;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void run() {
        logger.info(ConstLoggerMsg.LOGGER_START_TIMER);
        while (isActive) {
            notifyTimeObservers(seconds);
            try {
                Thread.sleep(Constants.MILI_CESONDS_PER_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds++;
        }
    }
}
