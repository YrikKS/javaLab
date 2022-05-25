package ru.nsu.kurgin.lab5.chat.client.entranceWindow;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerEntranceWindow extends ViewEntranceWindow {
    private ModelEntranceWindow modelEntranceWindow;

    @FXML
    private TextField textFieldWithLogin;

    @FXML
    void clickInButtonConnect(MouseEvent event) {
        modelEntranceWindow.connectToServer(textFieldWithLogin.getText());
    }

    public void setModelEntranceWindow(ModelEntranceWindow modelEntranceWindow) {
        this.modelEntranceWindow = modelEntranceWindow;
    }
}
