package ru.nsu.kurgin.lab5.chat.server.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;
import ru.nsu.kurgin.lab5.chat.server.Constants;

public class UserLogin extends CommandGetterType {
    private String userName;

    public void setUserLogin(String name) {
        setTypeCommand(Constants.COMMAND_USER_LOGIN);
        userName = name;
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {
        Gson gson = new Gson();
        commandExecutor.otherClientConnect(gson.fromJson(json, UserLogin.class));
    }
}
