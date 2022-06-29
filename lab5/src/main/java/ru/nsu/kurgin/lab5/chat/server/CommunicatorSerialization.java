package ru.nsu.kurgin.lab5.chat.server;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;

import java.io.*;
import java.net.Socket;

public class CommunicatorSerialization extends Thread implements Communicator {
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private CommandExecutor commandExecutor;
    private boolean activ = true;
    private String userName;

    public void setActivFalse() {
        this.activ = false;
    }


    public CommunicatorSerialization(Socket socket, CommandExecutor commandExecutor) throws IOException {
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        this.commandExecutor = commandExecutor;
        commandExecutor.setCommunicator(this);
        start();
    }


    @Override
    public void run() {
        CommandGetterType command = null;
        try {
            while (activ) {
                command = (CommandGetterType) in.readObject();
                commandExecutor.adapter(command);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("поймал");
            e.printStackTrace();
        }
    }

    @Override
    public void send(String msg) {

    }


    public void send(CommandGetterType command) {
        try {
            out.writeObject(command);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void sendAll(CommandGetterType command) {
        for (Communicator vr : Server.serverList) {
            vr.send(command);
        }
    }

    public void sendSpecificClient(CommandGetterType command) {
        send(command);
    }

    public void sendEveryoneExceptMyself(CommandGetterType command) {
        for (Communicator vr : Server.serverList) {
            if (!vr.getUserName().equals(this.userName))
                vr.send(command);
        }
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        userName = name;
    }

}