package ru.nsu.kurgin.lab5.chat.server.Command;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.CommandGetterType;

public class UserLogout extends CommandGetterType {
    private String userName;

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        modelMainWindow.delMemberToChat(this);
    }

    public String getUserName() {
        return userName;
    }
}
