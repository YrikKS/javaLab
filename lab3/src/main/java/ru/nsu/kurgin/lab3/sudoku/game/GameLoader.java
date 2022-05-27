package ru.nsu.kurgin.lab3.sudoku.game;

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
import ru.nsu.kurgin.lab3.sudoku.time.MyTimer;

public class GameLoader extends Application implements InterfaceLoaders {
    private static final Logger logger = LogManager.getLogger(GameLoader.class);
    private MyTimer myTimer = new MyTimer();
    private GameModel gameModel = new GameModel();
    private GameController controller;
    private GameViewer viewer = new GameViewer();


    @Override
    public void start(Stage gameStage) throws Exception {
        logger.info(ConstLoggerMsg.LOGGER_LOAD_MAIN_GAME);
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource(Constants.FXML_NAME_GAME));

        Scene gameScene = new Scene(fxmlLoader.load(), Constants.WIDTH_SCENE, Constants.HEIGHT_SCENE);
        controller = fxmlLoader.getController();
        myTimer.addObserver(viewer);
        viewer.setGameModelAndController(gameModel, controller);
        gameModel.addObserver(viewer);
        gameModel.setMyTimer(myTimer);
        controller.setGameModel(gameModel);
        gameStage.setScene(gameScene);
        gameStage.show();

        gameStage.setOnCloseRequest(we -> myTimer.setActive(false));
    }

    public void applicationStart(Stage stage) throws Exception {
        start(stage);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
