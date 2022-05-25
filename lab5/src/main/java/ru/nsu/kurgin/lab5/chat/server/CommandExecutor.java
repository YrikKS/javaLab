package ru.nsu.kurgin.lab5.chat.server;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.server.Exeption.FabricExceptions;
import ru.nsu.kurgin.lab5.chat.server.Command.*;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private final FabricCommand fabricCommand = new FabricCommand();
    private СommunicatorForClients communicator;

    public CommandExecutor() {
        try {
            fabricCommand.configurateFabric();
        } catch (FabricExceptions e) {
            e.printStackTrace();
        }
    }

    public void setCommunicator(СommunicatorForClients communicator) {
        this.communicator = communicator;
    }

    public void clientConnect(Login login) {
        communicator.setUserName(login.getUserName());
        UserLogin userLogin = new UserLogin();
        userLogin.setUserLogin(login.getUserName());
        communicator.sendAll(userLogin);
    }

    public void clientLogout(Logout logout) {
        communicator.setActivFalse();
        Server.delMember(communicator);

        UserLogout userLogout = new UserLogout();
        userLogout.setUserLogout(logout.getUserName());
        communicator.sendEveryoneExceptMyself(userLogout);
    }

    public void jsonAdapter(String json) {
        Gson gson = new Gson();
        fabricCommand.getCommand(gson.fromJson(json, CommandReader.class).getTypeCommand()).runCommand(this, json);
    }

    public void otherClientConnect(UserLogin userLogin) {
        communicator.sendAll(userLogin);
    }

    public void addMassage(Massage msg) {
        communicator.sendAll(msg);
    }

    public void otherClientDisconnect(UserLogout userLogout) {
        communicator.sendEveryoneExceptMyself(userLogout);
    }

    public void sendListUsers() {
        ListUsers listUsers = new ListUsers();
        List<String> listsName = new ArrayList<>();
        for (СommunicatorForClients vr : Server.serverList) {
            listsName.add(vr.getUserName());
        }
        listUsers.setListUsers(listsName);
        communicator.sendSpecificClient(listUsers);
    }


}
