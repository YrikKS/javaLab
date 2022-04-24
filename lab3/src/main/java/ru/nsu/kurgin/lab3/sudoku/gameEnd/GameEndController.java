package ru.nsu.kurgin.lab3.sudoku.gameEnd;

public class GameEndController {
    private GameEndModel gameEndModel;

    public void returnToMenu() {
        gameEndModel.loadMenu();
    }

    public void newGame() {
        gameEndModel.gameLoad();
    }

    public void setGameEndModel(GameEndModel gameEndModel) {
        this.gameEndModel = gameEndModel;
    }
}
