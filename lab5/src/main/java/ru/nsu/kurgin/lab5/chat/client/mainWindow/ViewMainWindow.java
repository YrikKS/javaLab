package ru.nsu.kurgin.lab5.chat.client.mainWindow;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import ru.nsu.kurgin.lab5.chat.client.observer.ObserverChat;

public class ViewMainWindow implements ObserverChat {
    @FXML
    private TextArea chatTextArea;

    @FXML
    private TextArea membersTextArea;

    @Override
    public void update() {

    }

    @Override
    public void updateChat(String msg) {
        chatTextArea.appendText("\n" + msg);
    }

    @Override
    public void updateMember(String stringMembers) {
        membersTextArea.appendText(stringMembers);
    }

    @Override
    public void setMember(String stringMembers) {
        membersTextArea.setText(stringMembers);
    }
}
