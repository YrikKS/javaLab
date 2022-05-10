package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

import java.io.*;
import java.net.Socket;

public class ReadMsg extends Thread {
    private Socket clientSocket;
    private ModelMainWindow modelMainWindow;
    private BufferedReader readerToServer = null;
    private boolean activ = true;

    public void stopRead() {
        activ = false;
    }

    public ReadMsg(Socket clientSocket, ModelMainWindow modelMainWindow) {
        this.clientSocket = clientSocket;
        this.modelMainWindow = modelMainWindow;
        System.out.println(clientSocket);
        try {
            readerToServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String str;
        try {
            while (activ) {
                str = readerToServer.readLine(); // ждем сообщения с сервера
                System.out.println(str);
//                modelMainWindow.jsonAdapter(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
