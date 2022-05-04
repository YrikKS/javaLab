package ru.nsu.kurgin.lab3.sudoku.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.loaders.InterfaceLoaders;

public class MenuLoader extends Application implements InterfaceLoaders {

    private MenuController menuController;
    private MenuModel menuModel = new MenuModel();
    private MenuView menuViewer;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("menu.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 410, 656);
        menuController = fxmlLoader.getController();

        menuController.setMenuModel(menuModel);
        menuModel.addObserver(menuViewer);
        menuController.setMenuModel(menuModel);
        stage.setScene(scene);
        stage.show();
    }

    public void applicationStart(Stage stage) throws Exception {
        start(stage);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
