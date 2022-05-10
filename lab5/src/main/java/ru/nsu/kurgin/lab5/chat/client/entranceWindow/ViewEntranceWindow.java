package ru.nsu.kurgin.lab5.chat.client.entranceWindow;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import ru.nsu.kurgin.lab5.chat.client.observer.Observer;

public class ViewEntranceWindow implements Observer {
    private ModelEntranceWindow modelEntranceWindow = null;

    @FXML
    private Text errorText;

    @Override
    public void update() {
        errorText.setText("Can't connect");
    }

    public void setModelEntranceWindow(ModelEntranceWindow modelEntranceWindow) {
        this.modelEntranceWindow = modelEntranceWindow;
    }
}
