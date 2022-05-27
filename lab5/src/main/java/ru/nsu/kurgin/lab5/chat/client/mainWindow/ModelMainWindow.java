package ru.nsu.kurgin.lab5.chat.client.mainWindow;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.Client;
import ru.nsu.kurgin.lab5.chat.client.Constants;
import ru.nsu.kurgin.lab5.chat.server.Exeption.FabricExceptions;
import ru.nsu.kurgin.lab5.chat.client.entranceWindow.LoaderEntranceWindow;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.*;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.ReadMsg;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.WriteMsg;
import ru.nsu.kurgin.lab5.chat.client.observer.ObservableChat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sun.javafx.application.PlatformImpl.exit;

public class ModelMainWindow extends ObservableChat {
    private Socket clientSocket;
    private WriteMsg writeMsg;
    private ReadMsg readMsg;
    private List<String> chat = new ArrayList<>();
    private FabricCommand fabricCommand = new FabricCommand();
    private String nameUser;
    private List<String> listAllUsers = new ArrayList<>();

    public void setClientSocketAndUserName(Socket clientSocket, String nameUser) throws FabricExceptions {
        this.clientSocket = clientSocket;
        this.nameUser = nameUser;
        writeMsg = new WriteMsg(clientSocket, this);
        fabricCommand.configureFabric();
        readMsg = new ReadMsg(clientSocket, this);
        readMsg.start();
        System.out.println("add");
        login();
        sendRequest();
    }

    public void sendMsg(String textMsg) {
        Date date = new Date();
        Massage msg = new Massage(Constants.COMMAND_MASSAGE, nameUser, textMsg, date.getTime());
        writeMsg.sender(msg);
    }

    public void jsonAdapter(String json) {
        Gson gson = new Gson();
        System.out.println(json);
        fabricCommand.getCommand(gson.fromJson(json, CommandReader.class).getTypeCommand()).runCommand(this, json);
    }

    public void login() {
        Login login = new Login();
        login.setLogin(Constants.COMMAND_LOGIN, nameUser);
        writeMsg.sender(login);
    }

    public void sendNotificationLogout() {
        Logout logout = new Logout();
        logout.setLogout(nameUser);
        writeMsg.sender(logout);
        disconnect();
    }

    public void addAMassageToChat(Massage msg) {
        Date date = new Date(msg.getTimeSend());
        String dateStr = String.valueOf(date.getDate() + "." + (date.getMonth() + 1) + "." + (date.getYear() + 1900) + "  " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        notifyOfUpdateObserverChat("(" + dateStr + ") " + msg.getNameSender() + ": " + msg.getMassage());
    }

    public void addNewMemberToChat(UserLogin listUsers) {
        listAllUsers.add(listUsers.getUserName());
        notifyOfUpdateObserverMember(listUsers.getUserName());
    }

    public void delMemberToChat(UserLogout userLogout) {
        System.out.println(userLogout.getUserName());
        listAllUsers.remove(userLogout.getUserName());
        StringBuilder allMemberStr = new StringBuilder();
        for (String name : listAllUsers) {
            allMemberStr.append(name).append("\n");
        }
        notifyOfSetObserverMember(String.valueOf(allMemberStr));
    }

    public void loadAllMemberToChat(ListUsers userLogin) {
        listAllUsers.clear();
        listAllUsers = userLogin.getNameUsers();
        StringBuilder allMemberStr = new StringBuilder();
        for (String name : listAllUsers) {
            allMemberStr.append(name).append("\n");
        }
        notifyOfSetObserverMember(String.valueOf(allMemberStr));
    }

    public void sendRequest() {
        ListUsers listUsers = new ListUsers();
        listUsers.setTypeCommand(Constants.COMMAND_LIST_USERS);
        writeMsg.sender(listUsers);
    }

    public void readAnswer(Answer answer) {
        if (answer.isError())
            System.err.println(answer.getErrorMassage());
    }


    public void serverEndWork() {
        try {
            readMsg.stopRead();
            writeMsg.closeBuffer();
            readMsg.closeBuffer();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            exit();
        }
        loadEntranceWindow();
    }

    public void disconnect() {
        try {
            writeMsg.closeBuffer();
            readMsg.closeBuffer();
            readMsg.stopRead();
            readMsg.interrupt();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            exit();
        }
    }

    public void loadEntranceWindow() {
        Client.setNewLoader(new LoaderEntranceWindow());
    }
}
