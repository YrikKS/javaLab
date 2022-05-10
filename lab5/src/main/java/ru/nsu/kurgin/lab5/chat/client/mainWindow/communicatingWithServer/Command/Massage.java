package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

public class Massage extends Command {
    private String userName;
    private long timeSend;
    private String massage;

    public void setMassage(String typeCommand, String name, String msg, long time) {
        setTypeCommand(typeCommand);
        this.massage = msg;
        this.timeSend = time;
        this.userName = name;
    }

    public String getNameSender() {
        return userName;
    }

    public long getTimeSend() {
        return timeSend;
    }

    public String getMassage() {
        return massage;
    }

    @Override
    public void runCommand(ModelMainWindow modelMainWindow) {
//        modelMainWindow.addAMassageToChat(this);
    }
}
