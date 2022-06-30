package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.CommandExecutor;

import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class ExecutorLogout implements ExecutorCommandInterface {

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        modelMainWindow.sendNotificationLogout();
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, CommandGetterType command) {
        modelMainWindow.sendNotificationLogout();
    }
}
