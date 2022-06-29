package ru.nsu.kurgin.lab5.chat.Command;

import ru.nsu.kurgin.lab5.chat.client.Constants;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

import java.io.Serial;
import java.io.Serializable;

public class Logout implements Serializable, CommandGetterType {
    @Serial
    private static final long serialVersionUID = 235160788758164721L;
    private String userName;

    public Logout() {
        setTypeCommand("logout");
    }
    public void setLogout(String name) {
        setTypeCommand(Constants.COMMAND_LOGOUT);
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
