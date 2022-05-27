package ru.nsu.kurgin.lab3.sudoku.Statistic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.lab3.sudoku.ConstLoggerMsg;
import ru.nsu.kurgin.lab3.sudoku.Constants;
import ru.nsu.kurgin.lab3.sudoku.game.GameModel;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.loaders.InterfaceLoaders;

public class StatisticsLoader extends Application implements InterfaceLoaders {
    private static final Logger logger = LogManager.getLogger(StatisticsLoader.class);
    private StatisticsController statisticsController;
    private StatisticsModel statisticsModel = new StatisticsModel();
    private StatisticsView statisticsViewer = new StatisticsView();

    @Override
    public void start(Stage stage) throws Exception {
        logger.info(ConstLoggerMsg.LOGGER_LOAD_STATS);
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource(Constants.FXML_NAME_STATISTICS));

        Scene scene = new Scene(fxmlLoader.load(), Constants.WIDTH_SCENE, Constants.HEIGHT_SCENE);
        statisticsController = fxmlLoader.getController();

        statisticsController.setStatisticsText();
        statisticsController.setMenuModel(statisticsModel);
        statisticsModel.addObserver(statisticsViewer);
        statisticsController.setMenuModel(statisticsModel);
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