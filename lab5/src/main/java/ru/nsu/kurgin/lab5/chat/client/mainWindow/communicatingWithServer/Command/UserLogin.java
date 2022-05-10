package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class UserLogin extends Command {
    private String userName;

    @Override
    public void runCommand(ModelMainWindow modelMainWindow) {
//        modelMainWindow.addNewMemberToChat(this);
    }

    public String getUserName() {
        return userName;
    }
}
