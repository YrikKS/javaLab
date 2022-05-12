package ru.nsu.kurgin.lab5.chat.server.Command;


import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;
import ru.nsu.kurgin.lab5.chat.server.Constants;

public class UserLogout extends CommandGetterType {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserLogout(String userName) {
        setTypeCommand(Constants.COMMAND_USER_LOGOUT);
        this.userName = userName;
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {
        Gson gson = new Gson();
        commandExecutor.otherClientDisconnect(gson.fromJson(json, UserLogout.class));
    }
}
