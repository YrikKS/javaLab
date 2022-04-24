package ru.nsu.kurgin.lab3.sudoku.gameEnd;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import ru.nsu.kurgin.lab3.sudoku.gameEnd.GameEndController;
import ru.nsu.kurgin.lab3.sudoku.gameEnd.GameEndModel;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observer;

import java.net.URL;
import java.util.ResourceBundle;

public class GameEndViewer implements Observer {
    private GameEndModel gameEndModel;
    private GameEndController gameEndController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    public void setTime(Integer time) {
        int sec = time % 60;
        int min = time / 60;
        String timeStr;
        if (min < 10)
            timeStr = "0" + min;
        else {
            timeStr = String.valueOf(min);
        }
        timeStr = timeStr + ":";

        if (sec < 10) {
            timeStr = timeStr + "0" + sec;
        } else
            timeStr = timeStr + sec;

        textTime.setText(timeStr);
    }


    public void setGameEndModelAndController(GameEndModel gameEndModel, GameEndController gameEndController) {
        this.gameEndModel = gameEndModel;
        this.gameEndController = gameEndController;
    }


    @FXML
    private Text textTime;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonNewGame;

    @FXML
    public void clickInButtonExit(MouseEvent event) {
        gameEndController.returnToMenu();
    }

    @FXML
    public void mouseClickedInNewGame(MouseEvent event) {
        gameEndController.newGame();
    }

    @FXML
    public void mouseExitExitButton(MouseEvent event) {
        buttonExit.setEffect(null);
    }

    @FXML
    public void mouseExitNewGame(MouseEvent event) {
        buttonNewGame.setEffect(null);
    }

    @FXML
    public void mouseInExitButton(MouseEvent event) {
        DropShadow shadow = new DropShadow();
        buttonExit.setEffect(shadow);
    }

    @FXML
    public void mouseInNewGame(MouseEvent event) {
        DropShadow shadow = new DropShadow();
        buttonNewGame.setEffect(shadow);
    }

    @Override
    public void update() {

    }
}
