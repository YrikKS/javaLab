package ru.nsu.kurgin.lab3.sudoku.gameEnd;

import ru.nsu.kurgin.lab3.sudoku.HelloApplication;
import ru.nsu.kurgin.lab3.sudoku.game.GameLoader;
import ru.nsu.kurgin.lab3.sudoku.menu.MenuLoader;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observable;

public class GameEndModel extends Observable {

    public void loadMenu() {
        HelloApplication.setNewLoader(new MenuLoader());
    }

    public void gameLoad() {
        HelloApplication.setNewLoader(new GameLoader());
    }
}
