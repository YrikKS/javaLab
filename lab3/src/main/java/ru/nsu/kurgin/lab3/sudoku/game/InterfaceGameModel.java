package ru.nsu.kurgin.lab3.sudoku.game;

import java.util.Vector;

public interface InterfaceGameModel {
    public void setOrDellNumInCell(Integer row, Integer col, Integer num);

    public void cancellationOfAction();

    public GameBoard getGameBoard();

    public Integer getNum(Integer row, Integer col);

    public Vector<Integer> getVersionNum(Integer row, Integer col);

    public void generateOrDelAllVersion();

    public void setOrDelOneVersionInCell(Integer row, Integer col, Integer versionNum);

    public void startTimer();

    public void update();
}
