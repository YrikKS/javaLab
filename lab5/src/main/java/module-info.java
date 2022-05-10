module ru.nsu.kurgin.lab5.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.google.gson;
    opens ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer to com.google.gson;

    opens ru.nsu.kurgin.lab5.chat.client to javafx.fxml;
    exports ru.nsu.kurgin.lab5.chat.client;
    opens ru.nsu.kurgin.lab5.chat.client.mainWindow to javafx.fxml;
    exports ru.nsu.kurgin.lab5.chat.client.mainWindow;
    opens ru.nsu.kurgin.lab5.chat.client.entranceWindow to javafx.fxml;
    exports ru.nsu.kurgin.lab5.chat.client.entranceWindow;
    opens ru.nsu.kurgin.lab5.chat.client.mainWindow.communicatingWithServer.Command to com.google.gson;
}