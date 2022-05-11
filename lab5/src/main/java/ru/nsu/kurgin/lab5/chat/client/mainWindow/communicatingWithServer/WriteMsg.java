package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.Constants;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.CommandInterface;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.Massage;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;


public class WriteMsg {
    private Socket clientSocket;
    private BufferedWriter senderInServer;
    private ModelMainWindow modelMainWindow;

    public WriteMsg(Socket clientSocket, ModelMainWindow modelMainWindow) {
        this.clientSocket = clientSocket;
        this.modelMainWindow = modelMainWindow;

        try {
            senderInServer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String str, String nameUser) throws IOException {
        Date date = new Date();
        Massage msg = new Massage();
        msg.setMassage(Constants.COMMAND_MASSAGE, nameUser, str, date.getTime());
        Gson gson = new Gson();
        String json = gson.toJson(msg);
        try {
            senderInServer.write(json + "\n"); // отправляем на сервер
            senderInServer.flush(); // чистим
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void sender(CommandInterface command) {
        Gson gson = new Gson();
        String json = gson.toJson(command);
        try {
            senderInServer.write(json + "\n"); // отправляем на сервер
            senderInServer.flush(); // чистим
        } catch (SocketException e) {
            e.printStackTrace();
            modelMainWindow.serverEndWork();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeBuffer() throws IOException {
        senderInServer.close();
    }
}