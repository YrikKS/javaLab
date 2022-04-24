package ru.nsu.kurgin.lab3.sudoku.Statistic;

public class StatisticsController {
    private StatisticsModel statisticsModel;

    public void setMenuModel(StatisticsModel statisticsModel) {
        this.statisticsModel = statisticsModel;
    }

    public void exitInMainMenu() {
        statisticsModel.loadMenu();
    }
}
