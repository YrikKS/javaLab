package ru.nsu.kurgin.lab5.chat.server.CommandExecutorFabric;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.Command.Massage;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;

public class ExecutorMassage implements ExecutorCommandInterface {
    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {
        Gson gson = new Gson();
        commandExecutor.addMassage(gson.fromJson(json, Massage.class));
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, CommandGetterType command) {
        commandExecutor.addMassage((Massage) command);
    }
}
