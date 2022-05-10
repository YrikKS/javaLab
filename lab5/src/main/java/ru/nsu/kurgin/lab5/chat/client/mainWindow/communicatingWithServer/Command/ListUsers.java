package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

import java.util.List;

public class ListUsers extends Command {
    private List<String> nameUsers;

    public void setListUsers(String typeCommand, List<String> name) {
        setTypeCommand(typeCommand);
        nameUsers = name;
    }

    public List<String> getNameUsers() {
        return nameUsers;
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow) {

    }
}
