package ru.nsu.kurgin.lab3.sudoku.menu;

import ru.nsu.kurgin.lab3.sudoku.HelloApplication;
import ru.nsu.kurgin.lab3.sudoku.Statistic.StatisticsLoader;
import ru.nsu.kurgin.lab3.sudoku.game.GameLoader;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observable;

import static javafx.application.Platform.exit;

public class MenuModel extends Observable {

    public void gameLoad() {
        HelloApplication.setNewLoader(new GameLoader());
    }

    public void statisticsLoad() {
        HelloApplication.setNewLoader(new StatisticsLoader());
    }

    public void exitGame() {
        exit();
    }
}
