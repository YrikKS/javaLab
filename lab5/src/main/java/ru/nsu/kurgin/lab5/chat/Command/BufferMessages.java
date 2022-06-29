package ru.nsu.kurgin.lab5.chat.Command;

import ru.nsu.kurgin.lab5.chat.server.Constants;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class BufferMessages implements Serializable, CommandGetterType {
    @Serial
    private static final long serialVersionUID = 123140586779391932L;
    private List<Massage> firstMessages;

    public BufferMessages() {
        setTypeCommand("bufferMessages");
    }

    public void setMessageBuffer(String typeCommand, List<Massage> messages) {
        firstMessages = messages;
    }

    public List<Massage> getMessageList() {
        return firstMessages;
    }

    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
