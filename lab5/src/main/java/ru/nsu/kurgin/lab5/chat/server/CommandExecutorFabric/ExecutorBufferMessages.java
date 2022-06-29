package ru.nsu.kurgin.lab5.chat.server.CommandExecutorFabric;

import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;


public class ExecutorBufferMessages implements ExecutorCommandInterface {

    @Override
    public void runCommand(CommandExecutor commandExecutor, String json) {
        commandExecutor.sendFirstMessages();
    }

    @Override
    public void runCommand(CommandExecutor commandExecutor, CommandGetterType command) {
        commandExecutor.sendFirstMessages();
    }
}
