package ru.nsu.kurgin.lab5.chat.server.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.CommandGetterType;

public class UserLogin extends CommandGetterType {
    private String userName;

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        Gson gson = new Gson();
        modelMainWindow.addNewMemberToChat(gson.fromJson(json, UserLogin.class));
    }

    public String getUserName() {
        return userName;
    }


}
