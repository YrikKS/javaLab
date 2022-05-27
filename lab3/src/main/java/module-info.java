module ru.nsu.kurgin.lab3.sudoku {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires log4j;

    opens ru.nsu.kurgin.lab3.sudoku to javafx.fxml;
    exports ru.nsu.kurgin.lab3.sudoku;
    exports ru.nsu.kurgin.lab3.sudoku.game;
    opens ru.nsu.kurgin.lab3.sudoku.game to javafx.fxml;
    exports ru.nsu.kurgin.lab3.sudoku.menu;
    opens ru.nsu.kurgin.lab3.sudoku.menu to javafx.fxml;
    exports ru.nsu.kurgin.lab3.sudoku.gameEnd;
    opens ru.nsu.kurgin.lab3.sudoku.gameEnd to javafx.fxml;
    exports ru.nsu.kurgin.lab3.sudoku.Statistic;
    opens ru.nsu.kurgin.lab3.sudoku.Statistic to javafx.fxml;

}