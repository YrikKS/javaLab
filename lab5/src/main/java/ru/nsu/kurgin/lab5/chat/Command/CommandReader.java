package ru.nsu.kurgin.lab5.chat.Command;

public class CommandReader implements CommandGetterType {
    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
