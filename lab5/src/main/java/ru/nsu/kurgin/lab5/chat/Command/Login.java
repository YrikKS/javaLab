package ru.nsu.kurgin.lab5.chat.Command;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.server.Constants;

import java.io.Serial;
import java.io.Serializable;

public class Login implements Serializable, CommandGetterType {
    @Serial
    private static final long serialVersionUID = 831150687788994323L;
    private String userName;

    public Login() {
        setTypeCommand("login");
    }

    public void setLogin(String typeCommand, String userName) {
        setTypeCommand(typeCommand);
        this.userName = userName;
    }

    public void setLogin(String userName) {
        setTypeCommand(Constants.COMMAND_LOGIN);
        this.userName = userName;
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
