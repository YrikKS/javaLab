package ru.nsu.kurgin.lab3.sudoku.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab3.sudoku.Constants;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.loaders.InterfaceLoaders;

public class MenuLoader extends Application implements InterfaceLoaders {

    private MenuController menuController;
    private MenuModel menuModel = new MenuModel();
    private MenuView menuViewer = new MenuView();

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource(Constants.FXML_NAME_MENU));

        Scene scene = new Scene(fxmlLoader.load(), Constants.WIDTH_SCENE, Constants.HEIGHT_SCENE);
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
