package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;

import ru.nsu.kurgin.lab5.chat.client.mainWindow.ModelMainWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public interface Reader {
    void stopRead();

    void run();

    void closeBuffer() throws IOException;

    void start();

    void interrupt();
}
