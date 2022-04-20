package ru.nsu.kurgin.lab3.sudoku.game;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import ru.nsu.kurgin.lab3.sudoku.Constatnts;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observer;

import java.util.Vector;

public class GameViewer implements Observer {

    @FXML
    private ImageView buttonForward;
    @FXML
    private ImageView buttonBack;

    private GameModel gameModel;
    private GameController gameController;

    @FXML
    private ToggleButton buttonOne;

    @FXML
    private GridPane mainPane;

    private Integer toolNumber = 0;

    public void setGameModelAndController(GameModel model, GameController controller) {
        gameModel = model;
        gameController = controller;
        model.update();
    }

    @FXML
    void clickMainPane(MouseEvent event) {

        if ((event.getPickResult().getIntersectedNode().getParent().getParent()).getClass().getName().equals("javafx.scene.layout.AnchorPane")) {
            int row = (int) event.getPickResult().getIntersectedNode().getParent().getParent().getLayoutY() / 45;
            int col = (int) event.getPickResult().getIntersectedNode().getParent().getParent().getLayoutX() / 45;
            System.out.println(event.getButton());
            if (event.getButton().name() == "PRIMARY")
                gameController.leftClickInCell(row, col);
            else if (event.getButton().name() == "SECONDARY")
                gameController.rightClickInCell(row, col);

        }
    }

    @Override
    public void update() {
        ObservableList<Node> lists = mainPane.getChildren();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Vector<Integer> versionNums = gameModel.getVersionNum(i, j);
                if (gameModel.getNum(i, j) != 0 && gameModel.getNum(i, j) != null) {
                    ((Text) (((GridPane) ((AnchorPane) lists.get(i * 9 + j)).getChildren().get(0)).getChildren().get(0))).setText(String.valueOf(gameModel.getNum(i, j)));
                    for (int k = 1; k < 10; k++)
                        ((Text) (((GridPane) ((AnchorPane) lists.get(i * 9 + j)).getChildren().get(0)).getChildren().get(k))).setText(null);
                } else {
                    ((Text) (((GridPane) ((AnchorPane) lists.get(i * 9 + j)).getChildren().get(0)).getChildren().get(0))).setText(null);
                    for (int k = 1; k < 10; k++) {
                        if (versionNums.get(k) == null || versionNums.get(k) == 0)
                            ((Text) (((GridPane) ((AnchorPane) lists.get(i * 9 + j)).getChildren().get(0)).getChildren().get(k))).setText(null);
                        else
                            ((Text) (((GridPane) ((AnchorPane) lists.get(i * 9 + j)).getChildren().get(0)).getChildren().get(k))).setText(String.valueOf(versionNums.get(k)));

                    }
                }
                if (toolNumber == 0) {
                    ((AnchorPane) lists.get(i * 9 + j)).setStyle(null);
                } else if (toolNumber == -1) {
                    ((AnchorPane) lists.get(i * 9 + j)).setStyle(null);
                } else if (gameModel.getNum(i, j) == toolNumber)
                    ((AnchorPane) lists.get(i * 9 + j)).setStyle(Constatnts.COLLOR_SELECTED_NUMBER);
                else {
                    ((AnchorPane) lists.get(i * 9 + j)).setStyle(null);
                    if (gameModel.getVersionNum(i, j).get(toolNumber) == toolNumber)
                        ((AnchorPane) lists.get(i * 9 + j)).setStyle(Constatnts.COLLOR_VERSION_SELECTED_NUMBER);
                    else
                        ((AnchorPane) lists.get(i * 9 + j)).setStyle(null);
                }

            }
        }
    }


    @FXML
    void click1(MouseEvent event) {
        toolNumber = 1;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    @FXML
    void click2(MouseEvent event) {
        toolNumber = 2;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    @FXML
    void forward(MouseEvent event) {
        System.out.println("ClickInForward");
        gameController.clickingOnTheNextActionButton();
    }

    @FXML
    void back(MouseEvent event) {
        System.out.println("ClickInCancsle");
        gameController.clickingOnTheCancelActionButton();
    }

    @FXML
    void click3(MouseEvent event) {
        toolNumber = 3;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    @FXML
    void click4(MouseEvent event) {
        toolNumber = 4;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    @FXML
    void click5(MouseEvent event) {
        toolNumber = 5;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    @FXML
    void click6(MouseEvent event) {
        toolNumber = 6;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    @FXML
    void click7(MouseEvent event) {
        toolNumber = 7;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    @FXML
    void click8(MouseEvent event) {
        toolNumber = 8;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    @FXML
    void click9(MouseEvent event) {
        toolNumber = 9;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    public void click(MouseEvent mouseEvent) {
    }

    public void dellButton(MouseEvent mouseEvent) {
        toolNumber = -1;
        gameController.clickOnToolNumb(toolNumber);
    }

    public void clickNoNumber(MouseEvent mouseEvent) {
        toolNumber = 0;
        gameController.clickOnToolNumb(toolNumber);
        update();
    }

    public void addMark(MouseEvent mouseEvent) {
        gameController.clickInDelOrSetAllVersion();
        update();
    }
}
