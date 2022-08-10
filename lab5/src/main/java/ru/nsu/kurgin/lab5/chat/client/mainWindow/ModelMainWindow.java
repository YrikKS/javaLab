package ru.nsu.kurgin.lab5.chat.client.mainWindow;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.*;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.client.Client;
import ru.nsu.kurgin.lab5.chat.client.Constants;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.*;
import ru.nsu.kurgin.lab5.chat.server.Exeption.FabricExceptions;
import ru.nsu.kurgin.lab5.chat.client.entranceWindow.LoaderEntranceWindow;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.CommandExecutor.*;
import ru.nsu.kurgin.lab5.chat.client.observer.ObservableChat;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sun.javafx.application.PlatformImpl.exit;

public class ModelMainWindow extends ObservableChat {
    private Socket clientSocket;
    private Writer writeMsg;
    private Reader readMsg;
    private List<String> chat = new ArrayList<>();
//    private final FabricCommand fabricCommand = new FabricCommand();
    private final FabricCommandExecutor fabricCommandExecutor = new FabricCommandExecutor();
    private String nameUser;
    private List<String> listAllUsers = new ArrayList<>();
    private List<Massage> listFirstMessages = new ArrayList<>();

    public void setClientSocketAndUserName(Socket clientSocket, String nameUser, String typeConnect) throws FabricExceptions {
        this.clientSocket = clientSocket;
        this.nameUser = nameUser;
        fabricCommandExecutor.configureFabric();
//        fabricCommand.configureFabric();
        if(typeConnect.equals("j")) {
            writeMsg = new WriteMsg(clientSocket, this);
            readMsg = new ReadMsg(clientSocket, this);
            readMsg.start();
        } else if (typeConnect.equals("s")) {
            writeMsg = new WriteMsgSerialization(clientSocket, this);
            readMsg = new ReadMsgSerialization(clientSocket, this);
            readMsg.start();
        }
//        System.out.println("add");
        login();
        sendRequest();
        sendMessagesRequest();
    }

    public void sendMessagesRequest() {
        BufferMessages bufferMessages = new BufferMessages();
        bufferMessages.setTypeCommand(Constants.COMMAND_FIRST_MESSAGES);
        writeMsg.sender(bufferMessages);
    }

    public void sendMsg(String textMsg) {
        Date date = new Date();
        Massage msg = new Massage(Constants.COMMAND_MASSAGE, nameUser, textMsg, date.getTime());
        writeMsg.sender(msg);
    }

    public void jsonAdapter(String json) {
        Gson gson = new Gson();
//        System.out.println("!!!" + json);
        fabricCommandExecutor.getCommand(gson.fromJson(json, CommandReader.class).getTypeCommand()).runCommand(this, json);
    }

    public void Adapter(CommandGetterType command) {
        fabricCommandExecutor.getCommand((command).getTypeCommand()).runCommand(this, command);
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

    public void loadFirstMessagesToChat(BufferMessages messagesList) {
        listFirstMessages.clear();
        listFirstMessages = messagesList.getMessageList();
        for (Massage msg : listFirstMessages) {
            addAMassageToChat(msg);
        }
    }

    public void addAMassageToChat(Massage msg) {
        Date date = new Date(msg.getTimeSend());
        String dateStr = String.valueOf(date.getDate() + "." + (date.getMonth() + 1) + "." + (date.getYear() + 1900) + "  " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        notifyOfUpdateObserverChat("(" + dateStr + ") " + msg.getNameSender() + ": " + msg.getMassage());
    }

    public void addNewMemberToChat(UserLogin listUsers) {
        listAllUsers.add(listUsers.getUserName());
        notifyOfUpdateObserverMember(listUsers.getUserName());
        Date date = new Date();
        String dateStr = String.valueOf(date.getDate() + "." + (date.getMonth() + 1) + "." + (date.getYear() + 1900) + "  " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        notifyOfUpdateObserverChat("(" + dateStr + ") : " + "New user " + listUsers.getUserName());
    }

    public void delMemberToChat(UserLogout userLogout) {
        Date date = new Date();
        String dateStr = String.valueOf(date.getDate() + "." + (date.getMonth() + 1) + "." + (date.getYear() + 1900) + "  " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        notifyOfUpdateObserverChat("(" + dateStr + ") " + "User exit " + userLogout.getUserName());
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
