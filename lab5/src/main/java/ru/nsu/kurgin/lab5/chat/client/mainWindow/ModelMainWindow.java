package ru.nsu.kurgin.lab5.chat.client.mainWindow;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.Exeption.FabricExceptions;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.*;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.ReadMsg;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.WriteMsg;
import ru.nsu.kurgin.lab5.chat.client.observer.ObservableChat;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ModelMainWindow extends ObservableChat {
    private Socket clientSocket;
    private WriteMsg writeMsg;
    private ReadMsg readMsg;
    private List<String> chat = new ArrayList<>();
//    private FabricCommand fabricCommand = new FabricCommand();
    private String nameUser;

    public void setClientSocketAndUserName(Socket clientSocket, String nameUser) throws FabricExceptions {
        this.clientSocket = clientSocket;
        this.nameUser = nameUser;
        writeMsg = new WriteMsg(clientSocket);
//        fabricCommand.configurateFabric();
        readMsg = new ReadMsg(clientSocket, this);
        readMsg.start();
    }

    public void stopReader() {
        readMsg.stopRead();
    }

    public void sendMsg(String msg) {
        writeMsg.sendMsg(msg, nameUser);
    }

//    public void getMsg(String msg) {
//        notifyObservers(msg);
//    }
//
//    public void jsonAdapter(String json) {
//        Gson gson = new Gson();
////        fabricCommand.getCommand(gson.fromJson(json, CommandReader.class).getTypeCommand()).runCommand(this);
//    }
//
//    public void login() {
//
//    }
//
//    public void logout() {
//
//    }
//
//    public void addAMassageToChat(Massage msg) {
//        System.out.println("RABOTAET!");
//    }
//
//    public void addNewMemberToChat(UserLogin listUsers) {
//
//    }
//
//    public void delMemberToChat(UserLogout userLogout) {
//
//    }
//
//    public void loadAllMemberTochat(ListUsers userLogin) {
//
//    }


//    listUsers ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.ListUsers
//    login ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.Login
//    logout ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.Logout
//    userLogin ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.UserLogin
//    userLogout ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.userLogout
}
