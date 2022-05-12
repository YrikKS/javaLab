package ru.nsu.kurgin.lab5.chat.server.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;
import ru.nsu.kurgin.lab5.chat.server.Constants;

public class Login extends CommandGetterType {
    private String userName;

    public void setLogin(String userName) {
        setTypeCommand(Constants.COMMAND_LOGIN);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {
        Gson gson = new Gson();
        commandExecutor.clientConnect(gson.fromJson(json, Login.class));
    }
}
