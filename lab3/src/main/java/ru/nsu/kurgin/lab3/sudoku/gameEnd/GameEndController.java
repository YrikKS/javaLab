package ru.nsu.kurgin.lab3.sudoku.gameEnd;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observer;
import ru.nsu.kurgin.lab3.sudoku.time.ConvertorSecondInNormal;

import java.net.URL;
import java.util.ResourceBundle;

public class GameEndController {
    public void setGameEndModel(GameEndModel gameEndModel) {
        this.gameEndModel = gameEndModel;
    }

    private GameEndModel gameEndModel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    public void setTime(Integer time) {
        textTime.setText(ConvertorSecondInNormal.convertSecond(time));
    }


    @FXML
    private Text textTime;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonNewGame;

    @FXML
    public void clickInButtonExit(MouseEvent event) {
        gameEndModel.loadMenu();
    }

    @FXML
    public void mouseClickedInNewGame(MouseEvent event) {
        gameEndModel.gameLoad();
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
}
