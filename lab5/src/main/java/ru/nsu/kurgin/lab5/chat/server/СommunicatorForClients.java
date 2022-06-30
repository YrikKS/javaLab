package ru.nsu.kurgin.lab5.chat.server;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;

import java.io.*;
import java.net.Socket;

public class СommunicatorForClients extends Thread  implements Communicator{
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private CommandExecutor commandExecutor;
    private boolean activ = true;
    private String userName;

    public void setActivFalse() {
        this.activ = false;
    }


    public СommunicatorForClients(Socket socket, CommandExecutor commandExecutor) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.commandExecutor = commandExecutor;
        commandExecutor.setCommunicator(this);
        start();
    }


    @Override
    public void run() {
        String command;
        try {
            while (activ) {
                command = in.readLine();
                if(activ)
                    commandExecutor.jsonAdapter(command);
            }
        } catch (IOException e) {
            System.out.println("поймал");
            e.printStackTrace();
        }
    }


    public void send(String msg) {
        try {
            System.out.println(msg);
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void send(CommandGetterType command) {

    }


    public void sendAll(CommandGetterType command) {
        Gson gson = new Gson();
        String json = gson.toJson(command);
        for (Communicator vr : Server.serverList) {
            vr.send(json);
        }
    }

    public void sendSpecificClient(CommandGetterType command) {
        Gson gson = new Gson();
        String json = gson.toJson(command);
//        System.out.println("!!!" + json);
        send(json);
    }

    public void sendEveryoneExceptMyself (CommandGetterType command) {
        Gson gson = new Gson();
        String json = gson.toJson(command);
        for (Communicator vr : Server.serverList) {
            if (!vr.getUserName().equals(this.userName))
                vr.send(json);
        }
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        userName = name;
    }

}
