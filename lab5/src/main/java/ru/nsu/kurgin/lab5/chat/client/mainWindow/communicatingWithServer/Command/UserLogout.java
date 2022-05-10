package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class UserLogout extends Command {
    private String userName;

    @Override
    public void runCommand(ModelMainWindow modelMainWindow) {
//        modelMainWindow.delMemberToChat(this);
    }

    public String getUserName() {
        return userName;
    }
}
