module ru.nsu.kurgin.lab5.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens ru.nsu.kurgin.lab5.chat.client to javafx.fxml;
    exports ru.nsu.kurgin.lab5.chat.client;
    opens ru.nsu.kurgin.lab5.chat.client.mainWindow to javafx.fxml;
    exports ru.nsu.kurgin.lab5.chat.client.mainWindow;
    opens ru.nsu.kurgin.lab5.chat.client.entranceWindow to javafx.fxml;
    exports ru.nsu.kurgin.lab5.chat.client.entranceWindow;
}