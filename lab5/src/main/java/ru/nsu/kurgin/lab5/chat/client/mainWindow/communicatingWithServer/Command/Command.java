package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

public abstract class Command implements CommandInterface{
    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
