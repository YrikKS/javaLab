package ru.nsu.kurgin.lab3.sudoku.menu;

import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.Statistic.StatisticsLoader;
import ru.nsu.kurgin.lab3.sudoku.game.GameLoader;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observable;

import static javafx.application.Platform.exit;

public class MenuModel extends Observable {

    public void gameLoad() {
        main.setNewLoader(new GameLoader());
    }

    public void statisticsLoad() {
        main.setNewLoader(new StatisticsLoader());
    }

    public void exitGame() {
        exit();
    }
}
