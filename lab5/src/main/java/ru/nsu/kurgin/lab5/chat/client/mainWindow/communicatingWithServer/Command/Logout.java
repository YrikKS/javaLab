package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class Logout extends Command {
    private String userName;

    public void setLogout(String typeCommand, String name) {
        setTypeCommand(typeCommand);
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow) {
//        modelMainWindow.logout();
    }
}
