package ru.nsu.kurgin.lab3.sudoku.Statistic;

import ru.nsu.kurgin.lab3.sudoku.Constants;
import ru.nsu.kurgin.lab3.sudoku.main;
import ru.nsu.kurgin.lab3.sudoku.menu.MenuLoader;
import ru.nsu.kurgin.lab3.sudoku.obeserver.Observable;

import java.io.*;
import java.util.Vector;

public class StatisticsModel extends Observable {

    public void loadMenu() {
        main.setNewLoader(new MenuLoader());
    }

    public static void setNewStats(Integer time) {
        Vector<Integer> records = new Vector<>();
        records.setSize(4);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.PATH_TO_FILE_STATS))) {
            String line = bufferedReader.readLine();
            Integer i = 0;
            while (line != null) {
                records.set(i, Integer.parseInt(line));
                line = bufferedReader.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constants.PATH_TO_FILE_STATS))) {
            records.set(3, time);
            records.sort(Integer::compareTo);

            Integer i = 0;
            while (i < 3) {
                System.out.println(records.get(i));
                bufferedWriter.write(records.get(i).toString() + "\n");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
