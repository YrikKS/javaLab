package ru.nsu.kurgin.lab5.chat.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.server.Constants;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListUsers implements Serializable, CommandGetterType {
    @Serial
    private static final long serialVersionUID = 134160587768584981L;
    private List<String> nameUsers;

    public ListUsers() {
        setTypeCommand("listUsers");
    }

    public void addName(String name) {
        nameUsers.add(name);
    }

    public void iniziallize() {
        nameUsers = new ArrayList<>();
    }

    public void setListUsers(String typeCommand, List<String> name) {
        setTypeCommand(typeCommand);
        nameUsers = name;
    }

    public void setListUsers(List<String> name) {
        nameUsers = new ArrayList<>();
        for(int i = 0; i < name.size(); i++) {
            nameUsers.add(name.get(i));
        }
        setTypeCommand(Constants.COMMAND_LIST_USERS);
//        nameUsers = name;
    }

    public List<String> getNameUsers() {
        return nameUsers;
    }

    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
