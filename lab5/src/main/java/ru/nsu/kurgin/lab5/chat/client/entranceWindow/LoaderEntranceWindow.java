package ru.nsu.kurgin.lab5.chat.client.entranceWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab5.chat.client.Constants;
import ru.nsu.kurgin.lab5.chat.client.loaders.InterfaceLoaders;
import ru.nsu.kurgin.lab5.chat.client.Client;

public class LoaderEntranceWindow extends Application implements InterfaceLoaders {
    private final ModelEntranceWindow modelEntranceWindow = new ModelEntranceWindow();

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource(Constants.ENTRANCE_WINDOW_FXML));
        Scene scene = new Scene(fxmlLoader.load(), Constants.WIDTH_WINDOW, Constants.HEIGHT_WINDOW);
        ControllerEntranceWindow controllerEntranceWindow = fxmlLoader.getController();

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
