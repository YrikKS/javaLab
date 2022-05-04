package ru.nsu.kurgin.lab3.sudoku.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.loaders.InterfaceLoaders;
import ru.nsu.kurgin.lab3.sudoku.time.MyTimer;

public class GameLoader extends Application implements InterfaceLoaders {
    private MyTimer myTimer = new MyTimer();
    private GameModel gameModel = new GameModel();
    private GameController controller;
    private GameViewer viewer = new GameViewer();


    @Override
    public void start(Stage gameStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("game.fxml"));

        Scene gameScene = new Scene(fxmlLoader.load(), 410, 656);
        controller = fxmlLoader.getController();
        myTimer.addObserver(viewer);
//        controller.setGameModel(gameModel);
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

//    @Override
//    public void applicationStart(Stage stage, Integer time) throws Exception {}

    public static void main(String[] args) {
        Application.launch();
    }
}
