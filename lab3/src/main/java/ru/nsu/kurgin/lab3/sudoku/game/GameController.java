package ru.nsu.kurgin.lab3.sudoku.game;

public class GameController {
    private GameModel gameModel;
    private Integer pressedNumber = 0;

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void clickOnToolNumb(Integer newPressedNumber) {
        pressedNumber = newPressedNumber;
    }

    public void leftClickInCell(Integer row, Integer col) {
        gameModel.setOrDellNumInCell(row, col, pressedNumber);
    }

    public void rightClickInCell(Integer row, Integer col) {
        gameModel.setOrDelOneVersionInCell(row, col, pressedNumber);
    }

    public void clickInDelOrSetAllVersion() {
        gameModel.generateOrDelAllVersion();
    }

    public void startTimer(){
        gameModel.startTimer();
    }

    public void clickingOnTheCancelActionButton() {
        gameModel.cancellationOfAction();
    }

    public void clickInExitButton() {
        gameModel.loadMenu();
    }
}
