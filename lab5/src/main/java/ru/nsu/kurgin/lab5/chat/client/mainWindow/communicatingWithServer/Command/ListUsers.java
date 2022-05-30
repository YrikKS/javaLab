package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

import java.util.List;

public class ListUsers extends CommandGetterType {
    private List<String> nameUsers;

    public ListUsers() {

    }

    public void setListUsers(String typeCommand, List<String> name) {
        setTypeCommand(typeCommand);
        nameUsers = name;
    }

    public List<String> getNameUsers() {
        return nameUsers;
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow, String json) {
        Gson gson = new Gson();
        modelMainWindow.loadAllMemberToChat(gson.fromJson(json, ListUsers.class));
    }
}
