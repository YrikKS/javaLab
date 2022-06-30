package ru.nsu.kurgin.lab5.chat.Command;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

import java.io.Serial;
import java.io.Serializable;

public class Massage implements Serializable, CommandGetterType {
    @Serial
    private static final long serialVersionUID = 7321104567587894221L;
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
        setTypeCommand("massage");
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

    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
