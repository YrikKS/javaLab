package ru.nsu.kurgin.lab5.chat.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.server.Constants;

import java.io.Serial;
import java.io.Serializable;

public class UserLogin implements Serializable, CommandGetterType {
    @Serial
    private static final long serialVersionUID = 2345102545677752116L;
    private String userName;

    public UserLogin() {
        setTypeCommand("userLogin");
    }
    public String getUserName() {
        return userName;
    }

    public void setUserLogin(String name) {
        setTypeCommand(Constants.COMMAND_USER_LOGIN);
        userName = name;
    }

    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
