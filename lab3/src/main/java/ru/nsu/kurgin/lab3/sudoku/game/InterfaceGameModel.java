package ru.nsu.kurgin.lab3.sudoku.game;

import java.util.Vector;

public interface InterfaceGameModel {

    Integer getNum(Integer row, Integer col);

    Vector<Integer> getVersionNum(Integer row, Integer col);
}
