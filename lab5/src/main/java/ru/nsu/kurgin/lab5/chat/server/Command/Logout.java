package ru.nsu.kurgin.lab5.chat.server.Command;

import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;
import ru.nsu.kurgin.lab5.chat.server.Constants;

public class Logout extends CommandGetterType {
    private String userName;

    public void setLogout(String name) {
        setTypeCommand(Constants.COMMAND_USER_LOGOUT);
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {

    }
}
