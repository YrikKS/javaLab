package ru.nsu.kurgin.lab5.chat.client.mainWindow;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import ru.nsu.kurgin.lab5.chat.client.observer.ObserverChat;

public class ViewMainWindow implements ObserverChat {
    @FXML
    private TextArea chatTextArea;

    @Override
    public void update() {

    }

    @Override
    public void updateChat(String msg) {
        chatTextArea.appendText("\n" + msg);
    }
}
