package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ReadMsgSerialization extends Thread implements Reader{
    private final ModelMainWindow modelMainWindow;
    private ObjectInputStream readerToServer = null;
    private boolean active = true;

    public void stopRead() {
        active = false;
    }

    public ReadMsgSerialization(Socket clientSocket, ModelMainWindow modelMainWindow) {
        this.modelMainWindow = modelMainWindow;
        System.out.println(clientSocket);
        try {
            readerToServer = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            while (active) {
                CommandGetterType command = (CommandGetterType) readerToServer.readObject();
                modelMainWindow.Adapter(command);
            }
        } catch (SocketException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeBuffer() throws IOException {
        readerToServer.close();
    }
}
