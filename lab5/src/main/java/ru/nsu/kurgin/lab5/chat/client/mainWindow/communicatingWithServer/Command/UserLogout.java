package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class UserLogout extends CommandGetterType {
    private String userName;

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        Gson gson = new Gson();
        modelMainWindow.delMemberToChat(gson.fromJson(json, UserLogout.class));
    }

    public String getUserName() {
        return userName;
    }
}
