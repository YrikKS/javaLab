package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.Answer;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ReadMsg extends Thread {
    private final ModelMainWindow modelMainWindow;
    private BufferedReader readerToServer = null;
    private boolean active = true;

    public void stopRead() {
        active = false;
    }

    public ReadMsg(Socket clientSocket, ModelMainWindow modelMainWindow) {
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
            while (active) {
                str = readerToServer.readLine();
                if (active)
                    modelMainWindow.jsonAdapter(str);
            }
        } catch (SocketException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeBuffer() throws IOException {
        readerToServer.close();
    }

    public Answer readAnswer() {
        String str = null;
        Gson gson = new Gson();
        Answer answer = null;
        try {
            str = readerToServer.readLine();
            answer = gson.fromJson(str, Answer.class);
        } catch (IOException e) {
            e.printStackTrace();
            modelMainWindow.serverEndWork();
        }
        return answer;
    }
}
