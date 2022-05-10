package ru.nsu.kurgin.lab5.chat.client.mainWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab5.chat.client.loaders.InterfaceLoaders;
import ru.nsu.kurgin.lab5.chat.client.Main;

public class LoaderMainWindow extends Application implements InterfaceLoaders{
    private ControllerMainWindow controllerMainWindow = new ControllerMainWindow();
    private ViewMainWindow viewMainWindow = new ViewMainWindow();
    private ModelMainWindow menuModel = new ModelMainWindow();

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        controllerMainWindow = fxmlLoader.getController();


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
