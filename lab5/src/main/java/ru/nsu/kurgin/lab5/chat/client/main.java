package ru.nsu.kurgin.lab5.chat.client;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab5.chat.client.entranceWindow.LoaderEntranceWindow;
import ru.nsu.kurgin.lab5.chat.client.loaders.InterfaceLoaders;
import ru.nsu.kurgin.lab5.chat.client.mainWindow.LoaderMainWindow;

import java.io.FileInputStream;
import java.io.InputStream;

public class main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage mainStage) throws Exception {
        stage = mainStage;
        stage.setTitle("aska");
        InputStream iconStream = new FileInputStream("Image\\icon.png");
        Image image = new Image(iconStream);
        stage.getIcons().add(image);

        LoaderMainWindow mainWindow = new LoaderMainWindow();
        try {
            mainWindow.applicationStart(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void setNewLoaderWithTime(InterfaceLoaders interfaceLoaders) {
        try {
            interfaceLoaders.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Application.launch();
    }
}
