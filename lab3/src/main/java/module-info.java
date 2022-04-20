module ru.nsu.kurgin.lab3.sudoku {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens ru.nsu.kurgin.lab3.sudoku to javafx.fxml;
    exports ru.nsu.kurgin.lab3.sudoku;
    exports ru.nsu.kurgin.lab3.sudoku.game;
    opens ru.nsu.kurgin.lab3.sudoku.game to javafx.fxml;
    exports ru.nsu.kurgin.lab3.sudoku.cells;
    opens ru.nsu.kurgin.lab3.sudoku.cells to javafx.fxml;
}