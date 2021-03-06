package ru.nsu.kurgin.lab5.chat.client.mainWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab5.chat.client.Constants;
import ru.nsu.kurgin.lab5.chat.client.loaders.InterfaceLoaders;
import ru.nsu.kurgin.lab5.chat.client.Client;

import java.net.Socket;

public class LoaderMainWindow extends Application implements InterfaceLoaders {
    private ControllerMainWindow controllerMainWindow;
    private ViewMainWindow viewMainWindow = new ViewMainWindow();
    private ModelMainWindow menuModel = new ModelMainWindow();
    private Socket clientSocket;
    private String userName;
    private String typeConnect;

    public LoaderMainWindow() {
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource(Constants.MAIN_WINDOW_FXML));
        Scene scene = new Scene(fxmlLoader.load(), Constants.WIDTH_WINDOW, Constants.HEIGHT_WINDOW);
        controllerMainWindow = fxmlLoader.getController();

        menuModel.setClientSocketAndUserName(this.clientSocket, this.userName, typeConnect);
        menuModel.addObserver(controllerMainWindow);
        controllerMainWindow.setModelMainWindow(menuModel);

        mainStage.setScene(scene);
        mainStage.show();

        mainStage.setOnCloseRequest(we -> menuModel.sendNotificationLogout());
    }

    @Override
    public void applicationStart(Stage stage) throws Exception {
        start(stage);
    }

    public static void main(String[] args) {
        Application.launch();
    }

    public String getTypeConnect() {
        return typeConnect;
    }

    public void setTypeConnect(String typeConnect) {
        this.typeConnect = typeConnect;
    }
}
