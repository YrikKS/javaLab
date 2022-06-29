package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.CommandExecutor;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.Answer;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;


public class ExecutorAnswer implements ExecutorCommandInterface {
    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        Gson gson = new Gson();
        modelMainWindow.readAnswer(gson.fromJson(json, Answer.class));
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, CommandGetterType command) {
        modelMainWindow.readAnswer((Answer) command);
    }
}
