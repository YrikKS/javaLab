package ru.nsu.kurgin.lab3.sudoku.menu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class MenuController {
    private MenuModel menuModel;

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonNewGame;

    @FXML
    private Button buttonStatistics;

    @FXML
    public Button buttonExit;

    public void clickInButtonExit(MouseEvent mouseEvent) {
        menuModel.exitGame();
    }

    @FXML
    public void mouseClickedInNewGame(MouseEvent event) {
        menuModel.gameLoad();
    }

    @FXML
    public void mouseClickedInStatistic(MouseEvent event) {
        menuModel.statisticsLoad();
    }

    @FXML
    public void mouseExitNewGame(MouseEvent event) {
        buttonNewGame.setEffect(null);
    }

    @FXML
    public void mouseExitStatistic(MouseEvent event) {
        buttonStatistics.setEffect(null);
    }

    @FXML
    public void mouseExitExitButton(MouseEvent mouseEvent) {
        buttonExit.setEffect(null);
    }

    @FXML
    public void mouseInNewGame(MouseEvent event) {
        DropShadow shadow = new DropShadow();
        buttonNewGame.setEffect(shadow);
    }

    @FXML
    public void mouseInStatistic(MouseEvent event) {
        DropShadow shadow = new DropShadow();
        buttonStatistics.setEffect(shadow);
    }

    public void mouseInExitButton(MouseEvent mouseEvent) {
        DropShadow shadow = new DropShadow();
        buttonExit.setEffect(shadow);
    }


    @FXML
    public void initialize() {

    }
}
