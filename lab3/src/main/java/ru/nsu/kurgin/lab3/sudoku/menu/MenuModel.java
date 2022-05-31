package ru.nsu.kurgin.lab3.sudoku.menu;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.lab3.sudoku.ConstLoggerMsg;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.Statistic.StatisticsLoader;
import ru.nsu.kurgin.lab3.sudoku.game.GameLoader;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observable;

import static javafx.application.Platform.exit;

public class MenuModel extends Observable{
    private static final Logger logger = LogManager.getLogger(MenuModel.class);

    public void gameLoad() {
        main.setNewLoader(new GameLoader());
    }

    public void statisticsLoad() {
        main.setNewLoader(new StatisticsLoader());
    }

    public void exitGame() {
        logger.info(ConstLoggerMsg.LOGGER_APPLICATION_END);
        main.closeApplication();
    }
}
