package ru.nsu.kurgin.lab5.chat.client.entranceWindow;

import ru.nsu.kurgin.lab5.chat.client.Main;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.LoaderMainWindow;
import ru.nsu.kurgin.lab5.chat.client.observer.Observable;

import java.io.IOException;
import java.net.Socket;

public class ModelEntranceWindow extends Observable {
    public void connectToServer() {
        try {
            Socket clientSocket = new Socket("localhost", 4004);
            Main.setNewLoader(new LoaderMainWindow());
        } catch (IOException e) {
            notifyObservers();
        }

    }
}
