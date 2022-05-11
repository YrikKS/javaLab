package ru.nsu.kurgin.lab5.chat.server.Command;

import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;

public class Login extends CommandGetterType {
    private String userName;

    public void setLogin(String typeCommand, String userName) {
        setTypeCommand(typeCommand);
        this.userName = userName;
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {

    }
}
