package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command.CommandInterface;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;


public class WriteMsg {
    private BufferedWriter senderInServer;
    private final ModelMainWindow modelMainWindow;

    public WriteMsg(Socket clientSocket, ModelMainWindow modelMainWindow) {
        this.modelMainWindow = modelMainWindow;
        try {
            senderInServer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sender(CommandInterface command) {
        Gson gson = new Gson();
        String json = gson.toJson(command);
        System.out.println(json);
        try {
            senderInServer.write(json);
            senderInServer.newLine();
            senderInServer.flush();
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
