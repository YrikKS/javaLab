package ru.nsu.kurgin.lab3.sudoku.Statistic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.loaders.InterfaceLoaders;

public class StatisticsLoader extends Application implements InterfaceLoaders {

    private StatisticsController statisticsController = new StatisticsController();
    private StatisticsModel statisticsModel = new StatisticsModel();
    private StatisticsViewer statisticsViewer;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("statistics.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 410, 656);
        statisticsViewer = fxmlLoader.getController();

        statisticsViewer.setStatisticsText();
        statisticsController.setMenuModel(statisticsModel);
        statisticsModel.addObserver(statisticsViewer);
        statisticsViewer.setMenuModelAndController(statisticsModel, statisticsController);
        stage.setScene(scene);
        stage.show();
    }

    public void applicationStart(Stage stage) throws Exception {
        start(stage);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}