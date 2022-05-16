package ru.nsu.kurgin.lab3.sudoku.game;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ru.nsu.kurgin.lab3.sudoku.Constants;
import ru.nsu.kurgin.lab3.sudoku.TimerObserver.TimerObserver;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observer;
import ru.nsu.kurgin.lab3.sudoku.time.ConvertorSecondInNormal;

import java.util.Vector;

public class GameViewer implements TimerObserver, Observer {
    private GameModel gameModel;
    private GameController gameController;
    private Integer toolNumber = 0;

    public void setGameModelAndController(GameModel model, GameController gameController) {
        gameModel = model;
        gameModel.startTimer();
        this.gameController = gameController;
        model.update();
    }

    @Override
    public void timerUpdate(Integer seconds) {
        gameController.timerText.setText(ConvertorSecondInNormal.convertSecond(seconds));
    }

    @Override
    public void update() {
        ObservableList<Node> lists = gameController.getMainPane().getChildren();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Vector<Integer> versionNums = gameModel.getVersionNum(i, j);
                if (gameModel.getNum(i, j) != 0 && gameModel.getNum(i, j) != null) {
                    if (!gameModel.isCellHaveNameInStartedBoard(i, j)) {
                        ((Text) ((GridPane) ((AnchorPane) lists.get(i * 9 + j)).getChildren().get(0)).getChildren().get(0)).setFont(Font.font("Lucida Bright Demibold", 38));
                        ((Text) ((GridPane) ((AnchorPane) lists.get(i * 9 + j)).getChildren().get(0)).getChildren().get(0)).setTranslateX(0);
                    }
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
                if (gameController.getToolNumber() == 0) {
                    ((AnchorPane) lists.get(i * 9 + j)).setStyle(null);
                } else if (gameController.getToolNumber() == -1) {
                    ((AnchorPane) lists.get(i * 9 + j)).setStyle(null);
                } else if (gameModel.getNum(i, j) == gameController.getToolNumber())
                    ((AnchorPane) lists.get(i * 9 + j)).setStyle(Constants.COLOR_SELECTED_NUMBER);
                else {
                    ((AnchorPane) lists.get(i * 9 + j)).setStyle(null);
                    if (gameModel.getVersionNum(i, j).get(gameController.getToolNumber()) == gameController.getToolNumber())
                        ((AnchorPane) lists.get(i * 9 + j)).setStyle(Constants.COLOR_VERSION_SELECTED_NUMBER);
                    else
                        ((AnchorPane) lists.get(i * 9 + j)).setStyle(null);
                }

            }
        }
    }
}
