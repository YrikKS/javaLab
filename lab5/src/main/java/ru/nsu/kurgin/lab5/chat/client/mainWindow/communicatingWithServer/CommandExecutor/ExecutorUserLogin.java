package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.CommandExecutor;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.Command.UserLogin;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class ExecutorUserLogin implements ExecutorCommandInterface {
    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
            Gson gson = new Gson();
            modelMainWindow.addNewMemberToChat(gson.fromJson(json, UserLogin.class));
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, CommandGetterType command) {
        modelMainWindow.addNewMemberToChat((UserLogin) command);
    }

}
