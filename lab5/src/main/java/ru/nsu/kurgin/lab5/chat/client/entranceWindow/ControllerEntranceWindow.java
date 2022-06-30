package ru.nsu.kurgin.lab5.chat.client.entranceWindow;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerEntranceWindow extends ViewEntranceWindow {
    @FXML
    public TextField textFieldWithIP;

    private ModelEntranceWindow modelEntranceWindow;

    @FXML
    private TextField textFieldWithLogin;

    @FXML
    void clickInButtonConnectJson(MouseEvent event) {
        modelEntranceWindow.connectToServer(textFieldWithLogin.getText(), textFieldWithIP.getText(), "j");
    }

    public void setModelEntranceWindow(ModelEntranceWindow modelEntranceWindow) {
        this.modelEntranceWindow = modelEntranceWindow;
    }

    public void clickInButtonConnect(MouseEvent mouseEvent) {
        modelEntranceWindow.connectToServer(textFieldWithLogin.getText(), textFieldWithIP.getText(), "s");
    }
}
