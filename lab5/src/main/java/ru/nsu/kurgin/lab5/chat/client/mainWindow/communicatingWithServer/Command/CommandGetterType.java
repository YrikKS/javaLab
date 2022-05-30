package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

public abstract class CommandGetterType implements CommandInterface{
    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
