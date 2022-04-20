package ru.nsu.kurgin.lab3.sudoku.cells;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import ru.nsu.kurgin.lab3.sudoku.game.GameModel;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observer;

public class MyCell implements Observer {
    GameModel gameModel;

    @FXML
    private Text firstBLockMainNumber;

    @FXML
    private Text firstBlockEight;

    @FXML
    private Text firstBlockFive;

    @FXML
    private Text firstBlockFour;

    @FXML
    private Text firstBlockNine;

    @FXML
    private Text firstBlockOne;

    @FXML
    private Text firstBlockSeven;

    @FXML
    private Text firstBlockSix;

    @FXML
    private Text firstBlockThree;

    @FXML
    private Text firstBlockTwo;

    @FXML
    void click(MouseEvent event) {
        String str = firstBLockMainNumber.getText();
        Integer numb = Integer.parseInt(str);
        numb = (numb + 1) % 10;
        firstBLockMainNumber.setText(numb.toString());
//        System.out.print((firstBLockMainNumber.getParent().getLayoutX() / 43));
//        System.out.print("   ");
//        System.out.println(firstBLockMainNumber.getParent().getParent().getParent().getLayoutY() / 43);

//        сontroller.buttonPush(sdfdsf)
//        firstBLockMainNumber.getParent().get
    }

    @FXML
    void initialize() {

    }

    public void setText (String str) {
        firstBLockMainNumber.setText(str);
    }

//    public void setGameModel(GameModel gameModel) {
//        this.gameModel = gameModel;
//    }

    @Override
    public void update() {
//        firstBLockMainNumber.setText();
    }
}


//    @FXML
//    void mouseClick(MouseEvent event) {
//        String str = firstBLockMainNumber.getText();
//        Integer numb = Integer.parseInt(str);
//        numb = (numb + 1) % 10;
//        firstBLockMainNumber.setText(numb.toString());
//    }