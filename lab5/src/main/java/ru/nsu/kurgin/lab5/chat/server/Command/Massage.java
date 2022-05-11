package ru.nsu.kurgin.lab5.chat.server.Command;

import ru.nsu.kurgin.lab5.chat.server.CommandExecutor;

public class Massage extends CommandGetterType {
    private String userName;
    private long timeSend;
    private String massage;

    public void setMassage(String typeCommand, String name, String msg, long time) {
        setTypeCommand(typeCommand);
        this.massage = msg;
        this.timeSend = time;
        this.userName = name;
    }


    public Massage() {

    }

    public Massage(String typeCommand, String name, String msg, long time) {
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
    public void runCommand(CommandExecutor commandExecutor, String json) {

    }
}
