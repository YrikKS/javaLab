package ru.nsu.kurgin.lab3.sudoku.menu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observer;

public class MenuViewer implements Observer {
    private MenuModel menuModel;
    private MenuController menuController;

    public void setMenuModelAndController(MenuModel menuModel, MenuController menuController) {
        this.menuModel = menuModel;
        this.menuController = menuController;
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
        menuController.clickInExitGame();
    }

    @FXML
    public void mouseClickedInNewGame(MouseEvent event) {
        menuController.clickInNewGame();
    }

    @FXML
    public void mouseClickedInStatistic(MouseEvent event) {
        menuController.clickInStatistics();
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

    @Override
    public void update() {

    }
}
