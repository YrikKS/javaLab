package ru.nsu.kurgin.lab5.chat.server;

import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;

public interface Communicator {
    public void setActivFalse();


    void run();

    void send(String msg);

    void send(CommandGetterType command);

    void sendAll(CommandGetterType command);

    void sendSpecificClient(CommandGetterType command);

    void sendEveryoneExceptMyself(CommandGetterType command);


    String getUserName();

    void setUserName(String name);
}
