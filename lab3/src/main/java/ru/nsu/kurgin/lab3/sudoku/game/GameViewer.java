package ru.nsu.kurgin.lab3.sudoku.game;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.lab3.sudoku.ConstLoggerMsg;
import ru.nsu.kurgin.lab3.sudoku.Constants;
import ru.nsu.kurgin.lab3.sudoku.TimerObserver.TimerObserver;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observer;
import ru.nsu.kurgin.lab3.sudoku.time.ConvertorSecondInNormal;

import java.util.Vector;

public class GameViewer implements TimerObserver, Observer {
    private static final Logger logger = LogManager.getLogger(GameViewer.class);

    private GameModel gameModel;
    private GameController gameController;

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
        logger.info(ConstLoggerMsg.LOGGER_VIEW_UPDATE);
        ObservableList<Node> lists = gameController.getMainPane().getChildren();
        for (int i = 0; i < Constants.SIZE_FIELD; i++) {
            for (int j = 0; j < Constants.SIZE_FIELD; j++) {
                Vector<Integer> versionNums = gameModel.getVersionNum(i, j);
                if (gameModel.getNum(i, j) != 0 && gameModel.getNum(i, j) != null) {
                    if (!gameModel.isCellHaveNameInStartedBoard(i, j)) {
                        ((Text) ((GridPane) ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).getChildren().get(0)).getChildren().get(0)).setFont(Font.font(Constants.FONT_TYPE, Constants.FONT_SIZE));
                        ((Text) ((GridPane) ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).getChildren().get(0)).getChildren().get(0)).setTranslateX(0);
                    }
                    ((Text) (((GridPane) ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).getChildren().get(0)).getChildren().get(0))).setText(String.valueOf(gameModel.getNum(i, j)));
                    for (int k = 1; k < Constants.SIZE_VECTOR_MARK; k++)
                        ((Text) (((GridPane) ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).getChildren().get(0)).getChildren().get(k))).setText(null);
                } else {
                    ((Text) (((GridPane) ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).getChildren().get(0)).getChildren().get(0))).setText(null);
                    for (int k = 1; k < Constants.SIZE_VECTOR_MARK; k++) {
                        if (versionNums.get(k) == null || versionNums.get(k) == 0)
                            ((Text) (((GridPane) ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).getChildren().get(0)).getChildren().get(k))).setText(null);
                        else
                            ((Text) (((GridPane) ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).getChildren().get(0)).getChildren().get(k))).setText(String.valueOf(versionNums.get(k)));
                    }
                }
                if (gameController.getToolNumber() == 0) {
                    ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).setStyle(null);
                } else if (gameController.getToolNumber() == -1) {
                    ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).setStyle(null);
                } else if (gameModel.getNum(i, j) == gameController.getToolNumber())
                    ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).setStyle(Constants.COLOR_SELECTED_NUMBER);
                else {
                    ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).setStyle(null);
                    if (gameModel.getVersionNum(i, j).get(gameController.getToolNumber()) == gameController.getToolNumber())
                        ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).setStyle(Constants.COLOR_VERSION_SELECTED_NUMBER);
                    else
                        ((AnchorPane) lists.get(i * Constants.SIZE_FIELD + j)).setStyle(null);
                }

            }
        }
    }
}
