package ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer;



import ru.nsu.kurgin.lab5.chat.Command.CommandGetterType;

import java.io.IOException;

public interface Writer {
    void sender(CommandGetterType command);
    void closeBuffer() throws IOException;
}
