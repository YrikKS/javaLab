package ru.nsu.kurgin.lab3.sudoku;

public class Constants {
    public static final String COLOR_VERSION_SELECTED_NUMBER = "-fx-background-color: #EEA66E";
    public static final String COLOR_SELECTED_NUMBER = "-fx-background-color: #FF8309"; //#DD6001
    public static final String COLOR_UNCORRECT_NUMBER = "-fx-background-color: #FF1E00"; //#DD6001
    public static final String FONT_TYPE = "Lucida Bright Demibold";
    public static final Integer FONT_SIZE = 38;

    public static final Integer SIZE_ONE_CELL = 45;
    public static final String NAME_ANCHOR_PANE = "javafx.scene.layout.AnchorPane";
    public static final String CLICK_RIGHT_MOUSE_BUTTON = "PRIMARY";
    public static final String CLICK_LEFT_MOUSE_BUTTON = "SECONDARY";

    public static final Integer WIDTH_SCENE = 410;
    public static final Integer HEIGHT_SCENE = 656;
    public static final String FXML_NAME_END_GAME = "gameEndv2.fxml";
    public static final String FXML_NAME_GAME = "game.fxml";
    public static final String FXML_NAME_MENU = "menu.fxml";
    public static final String FXML_NAME_STATISTICS = "statistics.fxml";


    public static final Integer TEXT_PLACE_FIRST_PEOPLE = 0;
    public static final Integer TEXT_PLACE_SECOND_PEOPLE = 1;
    public static final Integer TEXT_PLACE_THREE_PEOPLE = 2;

    public static final String PATH_TO_FILE_STATS = "src/main/java/ru/nsu/kurgin/lab3/sudoku/stats.txt";
    public static final String PATH_TO_ICON = "source/IconStage.png";
    public static final String PATH_TO_BASE_BOARD = "src/main/java/ru/nsu/kurgin/lab3/sudoku/SudokuBaseTable.txt";
    //Game Model Constants
    public static final Integer SIZE_SMALL_SQUARE = 3;
    public static final Integer SIZE_FIELD = 9;
    public static final Integer SIZE_VECTOR_MARK = 10;
    public static final Integer NUMBER_OF_RANDOM_CHANGES = 100;
    public static final Integer FIRST_ROWS_IN_SMALL_SQUARE = 3;
    public static final Integer SECOND_ROWS_IN_SMALL_SQUARE = 6;
    public static final Integer SIZE_STACK_MOMENT_IS_ZERO = 0;

    public static final Integer RAND_NUMB_SWAP_ROWS_SMALL = 0;
    public static final Integer RAND_NUMB_SWAP_COLUMS_SMALL = 1;
    public static final Integer RAND_NUMB_SWAP_DISTRICT_ROWS = 2;
    public static final Integer RAND_NUMB_SWAP_DISTRICT_COLUMS = 3;
    public static final Integer RAND_NUMB_TRANSPOSITION_BOARD = 4;
    public static final Integer SECONDS_PER_MINUTE = 60;
    public static final Integer MILI_CESONDS_PER_SECONDS = 1000;

}
