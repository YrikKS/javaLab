package ru.nsu.kurgin.lab5.chat.server.CommandExecutorFabric;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.Command.UserLogin;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;

public class ExecutorUserLogin implements ExecutorCommandInterface {
    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {
        Gson gson = new Gson();
        commandExecutor.otherClientConnect(gson.fromJson(json, UserLogin.class));
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, CommandGetterType command) {
        commandExecutor.otherClientConnect((UserLogin) command);
    }
}
