package ru.nsu.kurgin.lab3.sudoku;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.nsu.kurgin.lab3.sudoku.loaders.InterfaceLoaders;
import ru.nsu.kurgin.lab3.sudoku.menu.MenuLoader;
import ru.nsu.kurgin.lab3.sudoku.time.MyTimer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// TODO mainmenu
// TODO stats
// TODO time ++
// TODO uncorrect num placed
// TODO mb rework generator nums

public class main extends Application {
    private MyTimer myTimer = new MyTimer();
    private static Stage stage;

    @Override
    public void start(Stage mainStage) throws IOException {
        stage = mainStage;
        stage.setTitle("Sudoku");
        InputStream iconStream = new FileInputStream(Constants.PATH_TO_ICON);
        Image image = new Image(iconStream);
        stage.getIcons().add(image);
        MenuLoader menuLoader = new MenuLoader();

        try {
            menuLoader.applicationStart(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setNewLoader(InterfaceLoaders interfaceLoaders) {
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
