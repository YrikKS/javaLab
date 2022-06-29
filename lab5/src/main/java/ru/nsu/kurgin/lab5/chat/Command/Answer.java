package ru.nsu.kurgin.lab5.chat.Command;

import java.io.Serial;
import java.io.Serializable;

public class Answer implements Serializable, CommandGetterType {
    @Serial
    private static final long serialVersionUID = 439190989769594929L;

    private boolean error = false;
    private String errorMassage = null;

    public Answer() {
        setTypeCommand("answer");
    }

    public String getErrorMassage() {
        return errorMassage;
    }

    public void setErrorMassage(String errorMassage) {
        this.errorMassage = errorMassage;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    private String typeCommand;

    public String getTypeCommand() {
        return typeCommand;
    }

    public void setTypeCommand(String typeCommand) {
        this.typeCommand = typeCommand;
    }
}
