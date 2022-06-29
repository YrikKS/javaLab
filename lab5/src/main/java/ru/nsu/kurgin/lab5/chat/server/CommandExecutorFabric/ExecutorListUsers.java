package ru.nsu.kurgin.lab5.chat.server.CommandExecutorFabric;

import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;


public class ExecutorListUsers implements ExecutorCommandInterface {
    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {
        commandExecutor.sendListUsers();
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, CommandGetterType command) {
        commandExecutor.sendListUsers();
    }
}
