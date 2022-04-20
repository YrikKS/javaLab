package ru.nsu.kurgin.lab3.sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab3.sudoku.game.GameController;
import ru.nsu.kurgin.lab3.sudoku.game.GameModel;
import ru.nsu.kurgin.lab3.sudoku.game.GameViewer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
//        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("cell.fxml"));

//        controller.createCells();


        stage.setTitle("Sudoku");
        InputStream iconStream = new FileInputStream("source\\IconStage.png");
        Image image = new Image(iconStream);
        stage.getIcons().add(image);
//        stage.setWidth(414);
//        stage.setHeight(700);
//        stage.setMaxHeight(1200);
//        stage.setMaxWidth(1000);
//        stage.setMinHeight(300);
//        stage.setMinWidth(250);

//        Label helloWorldLabel = new Label("Hello world!");
//        helloWorldLabel.setAlignment(Pos.CENTER);
//        currentCells cells = new currentCells();
//        cells.setNumberNow();


        Scene menuScene = new Scene(fxmlLoader.load(), 410, 650);

        GameModel gameModel = new GameModel();
        GameViewer viewer = fxmlLoader.getController();
        GameController controller = new GameController();
        controller.setGameModel(gameModel);
        gameModel.addObserver(viewer);
        viewer.setGameModelAndController(gameModel, controller);
//        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        MyCell controller1 = fxmlLoader1.getController();
//        controller1.setText("2");
//        controller1.addObservable();
//        controller.setNum(3);

        stage.setScene(menuScene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
//        GameBoard gameBoard = new GameBoard();
//        gameBoard.printBoard();


    }
}
