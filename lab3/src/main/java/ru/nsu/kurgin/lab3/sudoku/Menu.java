package ru.nsu.kurgin.lab3.sudoku;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class Menu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonNewGame;

    @FXML
    private Button buttonResumeGame;

    @FXML
    private Button buttonStatistics;

    @FXML
    void mouseClickedInNewGame(MouseEvent event) {
        System.out.println("Click om New Game");
    }

    @FXML
    void mouseClickedInResume(MouseEvent event) {
        System.out.println("Click om Resume");
    }

    @FXML
    void mouseClickedInStatistic(MouseEvent event) {
        System.out.println("Click om Statictic");
    }

    @FXML
    void mouseExitNewGame(MouseEvent event) {
        buttonNewGame.setEffect(null);
    }

    @FXML
    void mouseExitResume(MouseEvent event) {
        buttonResumeGame.setEffect(null);
    }

    @FXML
    void mouseExitStatistic(MouseEvent event) {
        buttonStatistics.setEffect(null);
    }

    @FXML
    void mouseInNewGame(MouseEvent event) {
        DropShadow shadow = new DropShadow();
        buttonNewGame.setEffect(shadow);
    }

    @FXML
    void mouseInResume(MouseEvent event) {
        DropShadow shadow = new DropShadow();
        buttonResumeGame.setEffect(shadow);
    }

    @FXML
    void mouseInStatistic(MouseEvent event) {
        DropShadow shadow = new DropShadow();
        buttonStatistics.setEffect(shadow);
    }

    @FXML
    void initialize() {
//        assert buttonNewGame != null : "fx:id=\"button_new_game\" was not injected: check your FXML file 'menu.fxml'.";
//        assert buttonResumeGame != null : "fx:id=\"button_reusme_game\" was not injected: check your FXML file 'menu.fxml'.";
//        assert statistics != null : "fx:id=\"statistics\" was not injected: check your FXML file 'menu.fxml'.";

    }

}


//package ru.nsu.kurgin.lab3.sudoku;
//
//        import java.net.URL;
//        import java.util.ResourceBundle;
//        import javafx.fxml.FXML;
//        import javafx.scene.control.Button;
//        import javafx.scene.input.MouseEvent;
//
//public class Menu {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button buttonNewGame;
//
//    @FXML
//    private Button buttonReusmeGame;
//
//    @FXML
//    private Button buttonStatistics;
//
//    @FXML
//    void mouseClickedInNewGame(MouseEvent event) {
//
//    }
//
//    @FXML
//    void mouseClickedInResume(MouseEvent event) {
//
//    }
//
//    @FXML
//    void mouseClickedInStatistic(MouseEvent event) {
//
//    }
//
//    @FXML
//    void mouseExitNewGame(MouseEvent event) {
//
//    }
//
//    @FXML
//    void mouseExitResume(MouseEvent event) {
//
//    }
//
//    @FXML
//    void mouseExitStatistic(MouseEvent event) {
//
//    }
//
//    @FXML
//    void mouseInNewGame(MouseEvent event) {
//
//    }
//
//    @FXML
//    void mouseInResume(MouseEvent event) {
//
//    }
//
//    @FXML
//    void mouseInStatistic(MouseEvent event) {
//
//    }
//
//    @FXML
//    void initialize() {
//        assert buttonNewGame != null : "fx:id=\"buttonNewGame\" was not injected: check your FXML file 'menu.fxml'.";
//        assert buttonReusmeGame != null : "fx:id=\"buttonReusmeGame\" was not injected: check your FXML file 'menu.fxml'.";
//        assert buttonStatistics != null : "fx:id=\"buttonStatistics\" was not injected: check your FXML file 'menu.fxml'.";
//
//    }
//
//}

