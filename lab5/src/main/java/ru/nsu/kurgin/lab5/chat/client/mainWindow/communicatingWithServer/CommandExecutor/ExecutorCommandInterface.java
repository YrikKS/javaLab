package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.CommandExecutor;

import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public interface ExecutorCommandInterface {
    void runCommand(ModelMainWindow modelMainWindow, String json);
    void runCommand(ModelMainWindow modelMainWindow, CommandGetterType command);
}
