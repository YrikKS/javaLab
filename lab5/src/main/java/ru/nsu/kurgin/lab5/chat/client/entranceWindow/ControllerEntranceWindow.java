package ru.nsu.kurgin.lab5.chat.client.entranceWindow;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import ru.nsu.kurgin.lab5.chat.client.observer.Observer;

public class ControllerEntranceWindow extends ViewEntranceWindow implements Observer {
    private ModelEntranceWindow modelEntranceWindow;


    @FXML
    private TextField textFieldWithLoggin;

    @FXML
    void clickInButtonConnect(MouseEvent event) {
        modelEntranceWindow.connectToServer();
    }

    public void setModelEntranceWindow(ModelEntranceWindow modelEntranceWindow) {
        this.modelEntranceWindow = modelEntranceWindow;
    }
}