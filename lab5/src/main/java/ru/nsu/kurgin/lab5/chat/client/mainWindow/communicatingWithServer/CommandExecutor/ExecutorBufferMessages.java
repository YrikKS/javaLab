package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.CommandExecutor;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.BufferMessages;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class ExecutorBufferMessages implements ExecutorCommandInterface {

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        Gson gson = new Gson();
        modelMainWindow.loadFirstMessagesToChat(gson.fromJson(json, BufferMessages.class));
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, CommandGetterType command) {
        modelMainWindow.loadFirstMessagesToChat((BufferMessages) command);
    }
}
