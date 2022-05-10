package ru.nsu.kurgin.lab5.chat.client.entranceWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab5.chat.client.loaders.InterfaceLoaders;
import ru.nsu.kurgin.lab5.chat.client.Main;

public class LoaderEntranceWindow extends Application implements InterfaceLoaders {
    private ControllerEntranceWindow controllerEntranceWindow;
    private ViewEntranceWindow viewEntranceWindow = new ViewEntranceWindow();
    private ModelEntranceWindow modelEntranceWindow = new ModelEntranceWindow();

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("entranceWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        controllerEntranceWindow = fxmlLoader.getController();

        controllerEntranceWindow.setModelEntranceWindow(modelEntranceWindow);
        modelEntranceWindow.addObserver(controllerEntranceWindow);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @Override
    public void applicationStart(Stage stage) throws Exception {
        start(stage);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
