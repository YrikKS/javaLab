package ru.nsu.kurgin.lab3.sudoku.gameEnd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.lab3.sudoku.ConstLoggerMsg;
import ru.nsu.kurgin.lab3.sudoku.Constants;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.loaders.InterfaceLoaders;

import java.lang.constant.Constable;

public class GameEndLoader extends Application implements InterfaceLoaders {
    private static final Logger logger = LogManager.getLogger(GameEndLoader.class);

    private Integer time = 0;
    private GameEndController gameEndController;
    private GameEndModel gameEndModel = new GameEndModel();
    private GameEndView gameEndView = new GameEndView();

    @Override
    public void start(Stage stage) throws Exception {
        logger.info(ConstLoggerMsg.LOGGER_LOAD_END_GAME);

        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource(Constants.FXML_NAME_END_GAME));

        Scene scene = new Scene(fxmlLoader.load(), Constants.WIDTH_SCENE, Constants.HEIGHT_SCENE);
        gameEndController = fxmlLoader.getController();
        gameEndController.setTime(time);
        gameEndController.setGameEndModel(gameEndModel);
        gameEndModel.addObserver(gameEndView);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void applicationStart(Stage stage) throws Exception {
        start(stage);
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
