package ru.nsu.kurgin.lab3.sudoku.Statistic;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observer;
import ru.nsu.kurgin.lab3.sudoku.time.ConvertorSecondInNormal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class StatisticsViewer implements Observer {
    private StatisticsController statisticsController;
    private StatisticsModel statisticsModel;

    @FXML
    private Button buttonExit;

    @FXML
    private Text firstTimeText;

    @FXML
    private Text secondTimeText;

    @FXML
    private Text thirdTimeText;

    @FXML
    void clickInButtonExit(MouseEvent event) {
        statisticsController.exitInMainMenu();
    }

    @FXML
    void mouseExitExitButton(MouseEvent event) {
        buttonExit.setEffect(null);
    }

    @FXML
    void mouseInExitButton(MouseEvent event) {
        DropShadow shadow = new DropShadow();
        buttonExit.setEffect(shadow);
    }

    @Override
    public void update() {

    }

    public void setMenuModelAndController(StatisticsModel statisticsModel, StatisticsController statisticsController) {
        this.statisticsModel = statisticsModel;
        this.statisticsController = statisticsController;
    }

    public void setStatisticsText() {
        Vector<String> records = new Vector<>();
        records.setSize(3);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/ru/nsu/kurgin/lab3/sudoku/stats.txt"))) {
            String line = bufferedReader.readLine();
            Integer i = 0;
            while (line != null) {
                records.set(i, line);
                line = bufferedReader.readLine();
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        setRecords(records);
    }

    public void setRecords(Vector<String> records) {
        firstTimeText.setText(ConvertorSecondInNormal.convertSecond(records.get(0)));
        secondTimeText.setText(ConvertorSecondInNormal.convertSecond(records.get(1)));
        thirdTimeText.setText(ConvertorSecondInNormal.convertSecond(records.get(2)));
    }
}
