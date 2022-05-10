package ru.nsu.kurgin.lab5.chat.client.mainWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ControllerMainWindow extends ViewMainWindow{
    private ModelMainWindow modelMainWindow;

    @FXML
    private Button buttonSend;

    @FXML
    private TextArea massageTextArea;

    @FXML
    private TextArea membersTextArea;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void sendMassage(MouseEvent event) {
        System.out.println("view get " + massageTextArea.getText());
        modelMainWindow.sendMsg(massageTextArea.getText());
        massageTextArea.setText(null);
    }

    public void setModelMainWindow(ModelMainWindow modelMainWindow) {
        this.modelMainWindow = modelMainWindow;
    }

    @FXML
    void initialize() {

    }
}
