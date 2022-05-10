package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

import com.google.gson.*;
import ru.nsu.kurgin.lab5.chat.client.Constants;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.Massage;

public class WriteMsg {
    private Socket clientSocket;
    private BufferedWriter senderInServer = null;

    public WriteMsg(Socket clientSocket) {
        this.clientSocket = clientSocket;
        System.out.println(clientSocket);

        try {
            senderInServer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String str, String nameUser) {
        System.out.println("I try send in writeMsg " + str);
//        Date date = new Date();
//        Massage msg = new Massage();
//        msg.setMassage(Constants.COMMAND_MASSAGE, nameUser, str, date.getTime());
//        Gson gson = new Gson();
//        String json = gson.toJson(msg);
        try {
//            senderInServer.write(json); // отправляем на сервер
            senderInServer.write(str);
            senderInServer.flush(); // чистим
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}