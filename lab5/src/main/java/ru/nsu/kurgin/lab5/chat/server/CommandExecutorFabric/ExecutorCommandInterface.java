package ru.nsu.kurgin.lab5.chat.server.CommandExecutorFabric;


import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;

public interface ExecutorCommandInterface {
    void runCommand(CommandExecutor commandExecutor, String json);
    void runCommand(CommandExecutor commandExecutor, CommandGetterType command);
}
