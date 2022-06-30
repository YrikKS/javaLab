package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.CommandExecutor;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.Command.ListUsers;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class ExecutorListUsers implements ExecutorCommandInterface {

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        Gson gson = new Gson();
        modelMainWindow.loadAllMemberToChat(gson.fromJson(json, ListUsers.class));
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, CommandGetterType command) {
        modelMainWindow.loadAllMemberToChat((ListUsers) command);
    }
}
