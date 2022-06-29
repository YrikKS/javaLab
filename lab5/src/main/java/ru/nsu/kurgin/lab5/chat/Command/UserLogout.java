package ru.nsu.kurgin.lab5.chat.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.server.Constants;

import java.io.Serial;
import java.io.Serializable;

public class UserLogout implements Serializable, CommandGetterType {
    private String userName;
    @Serial
    private static final long serialVersionUID = 3445162748613752612L;

    public String getUserName() {
        return userName;
    }

    public void setUserLogout(String userName) {
        setTypeCommand("userLogout");
        this.userName = userName;
    }

    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
