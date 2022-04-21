package ru.nsu.kurgin.lab3.sudoku.game;

import ru.nsu.kurgin.lab3.sudoku.obeserver.Observable;

import java.util.List;
import java.util.Vector;

public class GameModel extends Observable {
    GameBoard gameBoard = new GameBoard();
    boolean versionIsInstalled = true;

    public void setOrDellNumInCell(Integer row, Integer col, Integer num) {
        if (gameBoard.isCellHaveNameInStartedBoard(row, col))
            return;
        if (num == -1) {
            gameBoard.dellAllVersionInCell(row, col);
            gameBoard.dellNumbInCell(row, col);
        } else if (num == 0) {
            notifyObservers();
            return;
        } else if (gameBoard.getFinalGameBoardCell(row, col) == num)
            gameBoard.dellNumbInCell(row, col);
        else
            gameBoard.setNumberInCell(row, col, num);
        notifyObservers();
    }

    public void cancellationOfAction(){
        gameBoard.loadMomento(-1);
        notifyObservers();
    }

    public void bringBackTheLastAction(){
        gameBoard.loadMomento(1);
        notifyObservers();
    }

    public void delAllInCell(Integer row, Integer col) {
        gameBoard.dellNumbInCell(row, col);
        gameBoard.dellAllVersionInCell(row, col);
        notifyObservers();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Integer getNum(int row, int col) {
        return gameBoard.getFinalGameBoardCell(row, col);
    }

    public Vector<Integer> getVersionNum(int row, int col) {
        return gameBoard.getVersionCell(row, col);
    }


    public void generateOrDelAllVersion() {
        if (versionIsInstalled) {
            gameBoard.dellVersionInCell();
            versionIsInstalled = false;
        } else {
            gameBoard.createVersionInCell();
            versionIsInstalled = true;
        }
        notifyObservers();
    }

    public void setOrDelOneVersionInCell(Integer row, Integer col, Integer versionNum) {
        if (gameBoard.isCellHaveNameInStartedBoard(row, col))
            return;
//        if (gameBoard.getFinalGameBoardCell())
        if (gameBoard.getVersionCell(row, col).get(versionNum) == versionNum)
            gameBoard.dellOneVersionInCell(row, col, versionNum);
        else
            gameBoard.setOneVersionInCell(row, col, versionNum);
        notifyObservers();
    }

    public GameModel() {

    }

    public List<Integer> getFiled() {
        return filed;
    }

    private List<Integer> filed;

    public void update() {
        notifyObservers();
    }


}
