package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class WriteMsgSerialization implements Writer {

    private ObjectOutputStream senderInServer;
    private final ModelMainWindow modelMainWindow;

    public WriteMsgSerialization(Socket clientSocket, ModelMainWindow modelMainWindow) {
        this.modelMainWindow = modelMainWindow;
        try {
            senderInServer = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sender(CommandGetterType command) {
        Gson gson = new Gson();
        String json = gson.toJson(command);
//        System.out.println(json);
        try {
            senderInServer.writeObject(command);
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
