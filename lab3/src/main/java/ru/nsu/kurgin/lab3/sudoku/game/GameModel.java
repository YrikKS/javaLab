package ru.nsu.kurgin.lab3.sudoku.game;

import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.Statistic.StatisticsModel;
import ru.nsu.kurgin.lab3.sudoku.gameEnd.GameEndLoader;
import ru.nsu.kurgin.lab3.sudoku.menu.MenuLoader;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observable;
import ru.nsu.kurgin.lab3.sudoku.time.MyTimer;

import java.util.Vector;

public class GameModel extends Observable implements InterfaceGameModel {
    private GameBoard gameBoard = new GameBoard(); //TODO set private
    private MyTimer myTimer;
    private boolean versionIsInstalled = true;


    public void setMyTimer(MyTimer myTimer) {
        this.myTimer = myTimer;
    }

    public void loadMenu() {
        myTimer.setActive(false);
        main.setNewLoader(new MenuLoader());
    }

    public boolean isCellHaveNameInStartedBoard(Integer row, Integer col) {
        return gameBoard.isCellHaveNameInStartedBoard(row, col);
    }

    public void setOrDellNumInCell(Integer row, Integer col, Integer num) {
        if (gameBoard.isCellHaveNameInStartedBoard(row, col))
            return;
        if (num == -1) {
            if (gameBoard.getMainNum(row, col) == 0)
                gameBoard.dellAllVersionInCell(row, col);
            else
                gameBoard.dellNumbInCell(row, col);
        } else if (num == 0) {
            notifyObservers();
            return;
        } else if (gameBoard.getFinalGameBoardCell(row, col) == num)
            gameBoard.dellNumbInCell(row, col);
        else
            gameBoard.setNumberInCell(row, col, num);
        notifyObservers();

        if (gameBoard.isGameEnd()) {
            if(gameBoard.isCorrectGameEnd()) {
                loadEndGame();
                StatisticsModel.setNewStats(myTimer.getSeconds());
            }
            else {
                System.out.println("Error");
                gameBoard.printBoard();
                gameBoard.printCorrectBoard();
            }
        }
    }

    public void loadEndGame() {
        myTimer.setActive(false);
        GameEndLoader gameEndLoader = new GameEndLoader();
        gameEndLoader.setTime(myTimer.getSeconds());
        main.setNewLoader(gameEndLoader);
    }

    public void cancellationOfAction() {
        gameBoard.loadMomento();
        notifyObservers();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    @Override
    public Integer getNum(Integer row, Integer col) {
        return gameBoard.getFinalGameBoardCell(row, col);
    }

    @Override
    public Vector<Integer> getVersionNum(Integer row, Integer col) {
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
        if (gameBoard.getMainNum(row, col) != 0)
            return;
        if (gameBoard.getVersionCell(row, col).get(versionNum) == versionNum)
            gameBoard.dellOneVersionInCell(row, col, versionNum);
        else
            gameBoard.setOneVersionInCell(row, col, versionNum);
        notifyObservers();
    }

    public void startTimer() {
        Thread myThready = new Thread(myTimer);
        myThready.start();
    }

    public void update() {
        notifyObservers();
    }

}
