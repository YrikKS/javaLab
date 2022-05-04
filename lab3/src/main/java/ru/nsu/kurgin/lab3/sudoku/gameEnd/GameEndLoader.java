package ru.nsu.kurgin.lab3.sudoku.gameEnd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.loaders.InterfaceLoaders;

public class GameEndLoader extends Application implements InterfaceLoaders  {
    private Integer time = 0;
    private GameEndController gameEndController = new GameEndController();
    private GameEndModel gameEndModel = new GameEndModel();
    private GameEndViewer gameEndViewer;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("gameEndv2.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 410, 656);
        gameEndViewer = fxmlLoader.getController();
        gameEndViewer.setTime(time);

        gameEndController.setGameEndModel(gameEndModel);
        gameEndModel.addObserver(gameEndViewer);
        gameEndViewer.setGameEndModelAndController(gameEndModel, gameEndController);

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
