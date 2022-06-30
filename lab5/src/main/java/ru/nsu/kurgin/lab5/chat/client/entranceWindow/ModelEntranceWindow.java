package ru.nsu.kurgin.lab5.chat.client.entranceWindow;

import ru.nsu.kurgin.lab5.chat.client.Client;
import ru.nsu.kurgin.lab5.chat.client.Constants;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.LoaderMainWindow;
import ru.nsu.kurgin.lab5.chat.client.observer.Observable;

import java.io.*;
import java.net.Socket;

public class ModelEntranceWindow extends Observable {
    public void connectToServer(String nameUser, String Ip, String typeConnect) {
        try {
            Socket clientSocket = new Socket(Ip, Constants.SOCKET);
            LoaderMainWindow loaderMainWindow = new LoaderMainWindow();

            loaderMainWindow.setTypeConnect(typeConnect);
            loaderMainWindow.setClientSocket(clientSocket);
            loaderMainWindow.setUserName(nameUser);
            Client.setNewLoader(loaderMainWindow);
        } catch (IOException e) {
            notifyObservers();
        }

    }
}
