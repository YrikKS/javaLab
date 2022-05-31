package ru.nsu.kurgin.lab3.sudoku.gameEnd;

import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.game.GameLoader;
import ru.nsu.kurgin.lab3.sudoku.menu.MenuLoader;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observable;

public class GameEndModel extends Observable {

    public void loadMenu() {
        main.setNewLoader(new MenuLoader());
    }

    public void gameLoad() {
        main.setNewLoader(new GameLoader());
    }
}
