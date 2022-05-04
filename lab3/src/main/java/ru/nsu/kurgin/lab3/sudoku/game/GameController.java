package ru.nsu.kurgin.lab3.sudoku.game;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class GameController {
    private GameModel gameModel;

    @FXML
    public Text timerText;

    public GridPane getMainPane() {
        return mainPane;
    }

    @FXML
    public GridPane mainPane;

    public Integer getToolNumber() {
        return toolNumber;
    }

    private Integer toolNumber = 0;

    public void setGameModel(GameModel model) {
        gameModel = model;
        gameModel.startTimer();
        model.update();
    }

    @FXML
    void clickMainPane(MouseEvent event) {
        if ((event.getPickResult().getIntersectedNode().getParent().getParent()).getClass().getName().equals("javafx.scene.layout.AnchorPane")) {
            int row = (int) event.getPickResult().getIntersectedNode().getParent().getParent().getLayoutY() / 45;
            int col = (int) event.getPickResult().getIntersectedNode().getParent().getParent().getLayoutX() / 45;
            if (event.getButton().name() == "PRIMARY") {
                gameModel.setOrDellNumInCell(row, col, toolNumber);
            } else if (event.getButton().name() == "SECONDARY")
                gameModel.setOrDelOneVersionInCell(row, col, toolNumber);
        }
    }

    @FXML
    void ExitButton(MouseEvent event) {
        gameModel.loadMenu();
    }

    @FXML
    void clickInBarWithNum(MouseEvent event) {
        toolNumber = 1;
        gameModel.update();
    }

    @FXML
    void click1(MouseEvent event) {
        toolNumber = 1;
        gameModel.update();
    }

    @FXML
    void click2(MouseEvent event) {
        toolNumber = 2;
        gameModel.update();
    }

    @FXML
    void back(MouseEvent event) {
        System.out.println("ClickInCancsle");
        gameModel.cancellationOfAction();
    }

    @FXML
    void click3(MouseEvent event) {
        toolNumber = 3;
        gameModel.update();
    }

    @FXML
    void click4(MouseEvent event) {
        toolNumber = 4;
        gameModel.update();
    }

    @FXML
    void click5(MouseEvent event) {
        toolNumber = 5;
        gameModel.update();
    }

    @FXML
    void click6(MouseEvent event) {
        toolNumber = 6;
        gameModel.update();
    }

    @FXML
    void click7(MouseEvent event) {
        toolNumber = 7;
        gameModel.update();
    }

    @FXML
    void click8(MouseEvent event) {
        toolNumber = 8;
        gameModel.update();
    }

    @FXML
    void click9(MouseEvent event) {
        toolNumber = 9;
        gameModel.update();
    }

    public void click(MouseEvent mouseEvent) {
    }

    public void dellButton(MouseEvent mouseEvent) {
        toolNumber = -1;
    }

    public void clickNoNumber(MouseEvent mouseEvent) {
        toolNumber = 0;
        gameModel.update();
    }

    public void addMark(MouseEvent mouseEvent) {
        gameModel.generateOrDelAllVersion();
        gameModel.update();
    }
}
