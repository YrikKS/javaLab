package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class WriteMsg extends Thread {
    private Socket clientSocket;
    private BufferedWriter senderInServer = null;
    private boolean activWriter = true;

    public WriteMsg(Socket clientSocket) {
        this.clientSocket = clientSocket;

        try {
            senderInServer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopWriterMsg() {
        activWriter = false;
    }

    @Override
    public void run() {
        while (activWriter) {
            String userWord;
            try {
                userWord = inputUser.readLine(); // сообщения с консоли
                if (userWord.equals("stop")) {
                    senderInServer.write("stop" + "\n");
                    break; // выходим из цикла если пришло "stop"
                } else {
                    senderInServer.write(userWord + "\n"); // отправляем на сервер
                }
                senderInServer.flush(); // чистим
            } catch (IOException e) {

            }

        }
    }
}