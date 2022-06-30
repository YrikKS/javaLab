package ru.nsu.kurgin.lab5.chat.server;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.server.CommandExecutorFabric.FabricCommandExecutor;
import ru.nsu.kurgin.lab5.chat.server.Exeption.FabricExceptions;
import ru.nsu.kurgin.lab5.chat.Command.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandExecutor {
    private final FabricCommandExecutor fabricCommand = new FabricCommandExecutor();
    private Communicator communicator;

    public CommandExecutor() {
        try {
            fabricCommand.configureFabric();
        } catch (FabricExceptions e) {
            e.printStackTrace();
        }
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    public void clientConnect(Login login) {
        communicator.setUserName(login.getUserName());
        UserLogin userLogin = new UserLogin();
        userLogin.setUserLogin(login.getUserName());
        communicator.sendEveryoneExceptMyself(userLogin);

        Date date = new Date();
        Massage massage = new Massage(Constants.COMMAND_MASSAGE, "", "New user " + login.getUserName(), date.getTime());
        Server.addMessage(massage);

        Answer answer = new Answer();
        answer.setError(false);
        communicator.sendSpecificClient(answer);
    }

    public void clientLogout(Logout logout) {
        communicator.setActivFalse();
        Server.delMember(communicator);

        Date date = new Date();
        Massage massage = new Massage(Constants.COMMAND_MASSAGE, "", "User exit " + logout.getUserName(), date.getTime());
        Server.addMessage(massage);

        UserLogout userLogout = new UserLogout();
        userLogout.setUserLogout(logout.getUserName());
        communicator.sendEveryoneExceptMyself(userLogout);
    }

    public void jsonAdapter(String json) {
        Gson gson = new Gson();
        fabricCommand.getCommand(gson.fromJson(json, CommandReader.class).getTypeCommand()).runCommand(this, json);
    }

    public void adapter(CommandGetterType command) {
        fabricCommand.getCommand(command.getTypeCommand()).runCommand(this, command);
    }

    public void otherClientConnect(UserLogin userLogin) {
        communicator.sendAll(userLogin);
    }

    public void addMassage(Massage msg) {
        Answer answer = new Answer();
        answer.setError(false);
        communicator.sendSpecificClient(answer);
        Server.addMessage(msg);
        communicator.sendAll(msg);
    }

    public void sendFirstMessages() {
        List<Massage> messages = new ArrayList<>();
        BufferMessages bufferMessages = new BufferMessages();
        for (Massage msg : Server.messageList) {
            messages.add(msg);
        }

        bufferMessages.setMessageBuffer(Constants.COMMAND_FIRST_MESSAGES, messages);
        communicator.sendSpecificClient(bufferMessages);
    }

    public void otherClientDisconnect(UserLogout userLogout) {
        communicator.sendEveryoneExceptMyself(userLogout);
    }

    public void sendListUsers() {
        ListUsers listUsers = new ListUsers();
        List<String> listsName = new ArrayList<>();
        listUsers.iniziallize();
        for (int i = 0; i < Server.serverList.size(); i++) {
            listUsers.addName(Server.serverList.get(i).getUserName());
        }
        communicator.sendSpecificClient(listUsers);
    }
}
