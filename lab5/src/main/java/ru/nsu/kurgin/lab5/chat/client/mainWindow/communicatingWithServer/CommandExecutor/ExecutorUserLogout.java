package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.CommandExecutor;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.Command.UserLogout;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class ExecutorUserLogout implements ExecutorCommandInterface {

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        Gson gson = new Gson();
        modelMainWindow.delMemberToChat(gson.fromJson(json, UserLogout.class));
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, CommandGetterType command) {
        modelMainWindow.delMemberToChat((UserLogout) command);
    }

}
