package ru.nsu.kurgin.lab3.sudoku.game;


import ru.nsu.kurgin.lab3.sudoku.momento.ModifiedMainNumber;
import ru.nsu.kurgin.lab3.sudoku.momento.ModifiedVersionNumber;
import ru.nsu.kurgin.lab3.sudoku.momento.Momento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameBoard {

    private Vector<Vector<Integer>> finalGameBoard;
    private Vector<Vector<Integer>> gameBoard;
    private Vector<Vector<Vector<Integer>>> versionInCells;
    private List<Momento> momentos = new ArrayList<>();
    private Integer positionOnList = 0;

    public void loadMomento(Integer load) {
        if (momentos.size() == 0 || positionOnList + load < 0) {
            System.out.println("momentos == 0");
            return;
        }
        if (momentos.size() < positionOnList + load)
            return;
        positionOnList += load;
        if (load == -1) {
            Momento moment = momentos.get(positionOnList);
            ModifiedMainNumber modifiedMainNumber = moment.getModifiedMainNumber();
            if (modifiedMainNumber.isMainNumberModified())
                gameBoard.get(modifiedMainNumber.getRowWithModifiedCell()).set(modifiedMainNumber.getColWithModifiedCell(), modifiedMainNumber.getNumberThatWasBefore());
            Vector<ModifiedVersionNumber> vectorModifiedVersionNumber = moment.getvectorModifiedVersionNumber();

            for (int i = 0; i < vectorModifiedVersionNumber.size(); i++) {
                ModifiedVersionNumber modifiedVersionNumber = vectorModifiedVersionNumber.get(i);
                versionInCells.get(modifiedVersionNumber.getRowWithModifiedCell())
                        .get(modifiedVersionNumber.getColWithModifiedCell()).set(modifiedVersionNumber.getPositionVersion(), modifiedVersionNumber.getNumberThatWasBefore());
            }
        }

//        if (load == 1) {
//            Momento moment = momentos.get(positionOnList);
//            ModifiedMainNumber modifiedMainNumber = moment.getModifiedMainNumber();
//            if (modifiedMainNumber.isMainNumberModified())
//                gameBoard.get(modifiedMainNumber.getRowWithModifiedCell()).set(modifiedMainNumber.getColWithModifiedCell(), modifiedMainNumber.getNumberThatBecame());
//            Vector<ModifiedVersionNumber> vectorModifiedVersionNumber = moment.getvectorModifiedVersionNumber();
//
//            for (int i = 0; i < vectorModifiedVersionNumber.size(); i++) {
//                ModifiedVersionNumber modifiedVersionNumber = vectorModifiedVersionNumber.get(i);
//                versionInCells.get(modifiedVersionNumber.getRowWithModifiedCell())
//                        .get(modifiedVersionNumber.getColWithModifiedCell()).set(modifiedVersionNumber.getPositionVersion(), modifiedVersionNumber.getNumberThatBecame());
//            }
//        }
    }

    public Integer getFinalGameBoardCell(int a, int b) {
        return finalGameBoard.get(a).get(b);
    }

    public void dellAllVersionInCell(int a, int b) {
        for (int i = 0; i < 9; i++)
            versionInCells.get(a).get(b).set(i, 0);
    }

    public void dellOneVersionInCell(Integer row, Integer col, Integer versionNum) {
        versionInCells.get(row).get(col).set(versionNum, 0);
    }

    public void setOneVersionInCell(Integer row, Integer col, Integer versionNum) {
        versionInCells.get(row).get(col).set(versionNum, versionNum);
    }

    public void dellNumbInCell(int a, int b) {
        finalGameBoard.get(a).set(b, 0);
    }

    public void setNumberInCell(Integer row, Integer col, Integer num) {
        checkMomento();
        Momento momento = new Momento();
        momento.addModifedMainNumber(row, col, gameBoard.get(row).get(col), num);
        gameBoard.get(row).set(col, num);

        for (int k = 0; k < 9; k++) {
            int passageThroughSquare = 0;
            if (k < 3) passageThroughSquare = 0;
            if (k >= 3 && k < 6) passageThroughSquare = 1;
            if (k >= 6) passageThroughSquare = 2;
            if (versionInCells.get(row).get(k).get(num) == (num)) {
                versionInCells.get(row).get(k).set(num, 0);
                momento.addVersionInVector(row, k, num, 0);
            }
            if (versionInCells.get(k).get(col).get(num) == (num)) {
                versionInCells.get(k).get(col).set(num, 0);
                momento.addVersionInVector(k, col, num, 0);
            }

            if (versionInCells.get(row / 3 * 3 + k % 3).get(col / 3 * 3 + passageThroughSquare).get(num) == (num)) {
                versionInCells.get(row / 3 * 3 + k % 3).get(col / 3 * 3 + passageThroughSquare).set(num, 0);
                momento.addVersionInVector(row / 3 * 3 + k % 3, col / 3 * 3 + passageThroughSquare, num, 0);
            }
            if (versionInCells.get(row).get(col).get(k + 1) != 0 && versionInCells.get(row).get(col).get(k + 1) != null)
                momento.addVersionInVector(row, col,k + 1, k + 1);
            versionInCells.get(row).get(col).set(k + 1, 0);
        }
        momentos.add(momento);
        positionOnList++;
    }

    private void checkMomento() {
        while (momentos.size() != positionOnList) {
            momentos.remove(momentos.size() - 1);
            System.out.println(momentos.size());
            System.out.println(positionOnList);
//            System.out.println(momentos.get(positionOnList).getModifiedMainNumber().getNumberThatBecame());
        }
    }

    public Vector<Integer> getVersionCell(int a, int b) {
        return versionInCells.get(a).get(b);
    }

    public Integer getCorrectNumberForCell(int a, int b) {
        return gameBoard.get(a).get(b);
    }

    public GameBoard() {
        generateGameBoard();
    }


    private void generateGameBoard() {
        finalGameBoard = new Vector<>();
        finalGameBoard.setSize(9);
        for (int i = 0; i < 9; i++) {
            finalGameBoard.set(i, new Vector<>());
            finalGameBoard.get(i).setSize(9);
        }
        generateNumInGameBoard();
        gameBoard = finalGameBoard;
        for (int k1 = 0; k1 < 9; k1++) {
            for (int k2 = 0; k2 < 9; k2++)
                deleteCells(k1, k2);
        }
        changesRandomGameBoard();
        printBoard();

        versionInCells = new Vector<>();
        versionInCells.setSize(9);
        for (int i = 0; i < 9; i++) {
            versionInCells.set(i, new Vector<>());
            versionInCells.get(i).setSize(9);
            for (int j = 0; j < 9; j++) {
                versionInCells.get(i).set(j, new Vector<>());
                versionInCells.get(i).get(j).setSize(10);
            }
        }
        createVersionInCell();
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
            System.out.print("   ");
            System.out.println(versionInCells.get(0).get(0).get(i));
        }
    }

    public void createVersionInCell() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {

                if (finalGameBoard.get(i).get(j) == 0) {
                    boolean numCanPlaceInCells = false;
                    for (int num = 1; num < 10; num++) {
                        for (int k = 0; k < 9; k++) {
                            int passageThroughSquare = 0;
                            if (k < 3) passageThroughSquare = 0;
                            if (k >= 3 && k < 6) passageThroughSquare = 1;
                            if (k >= 6) passageThroughSquare = 2;
                            if (finalGameBoard.get(i).get(k) == num || finalGameBoard.get(k).get(j) == num || finalGameBoard.get(i / 3 * 3 + k % 3).get(j / 3 * 3 + passageThroughSquare) == num) {
                                numCanPlaceInCells = true;
                                break;
                            }
                        }
                        if (!numCanPlaceInCells) {
                            versionInCells.get(i).get(j).set(num, num);
                        } else versionInCells.get(i).get(j).set(num, 0);
                        numCanPlaceInCells = false;
                    }
                }

            }
    }

    public void dellVersionInCell() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int num = 1; num < 10; num++)
                    versionInCells.get(i).get(j).set(num, 0);
            }
        }
    }

    public void deleteCells(int k1, int k2) {
        int i, j, b, c;
        int temp = finalGameBoard.get(k1).get(k2);
        int count = 9;
        for (i = 1; i <= 9; i++) {
            int flag = 1;
            for (j = 0; j < 9; j++) {
                if (j != k2) {
                    if (i != finalGameBoard.get(k1).get(j)) {
                        continue;
                    } else {
                        flag = 0;
                        break;
                    }
                }
            }
            if (flag == 1) {
                for (c = 0; c < 9; c++) {
                    if (c != k1) {
                        if (i != finalGameBoard.get(c).get(k2)) {
                            continue;
                        } else {
                            flag = 0;
                            break;
                        }
                    }
                }
            }
            if (flag == 1) {
                int rem1 = k1 % 3;
                int rem2 = k2 % 3;
                int row_from = k1 - rem1;
                int row_to = k1 + (2 - rem1);
                int col_from = k2 - rem2;
                int col_to = k2 + (2 - rem2);
                for (c = row_from; row_to >= c; c++) {
                    for (b = col_from; b <= col_to; b++) {
                        if (c != k1 && b != k2) {
                            if (i != finalGameBoard.get(c).get(b)) continue;
                            else {
                                flag = 0;
                                break;
                            }
                        }
                    }
                }
            }
            if (flag == 0) count--;
        }
        if (count == 1) {
            finalGameBoard.get(k1).set(k2, 0);
            count--;
        }

    }

    private void changesRandomGameBoard() {
        for (int i = 0; i < 1000; i++) {
            int versionChanges = (int) (Math.random() * 5);
            if (versionChanges == 0)
                swapRowsSmall((int) (Math.random() * 3), (int) (Math.random() * 3), (int) (Math.random() * 3));

            if (versionChanges == 1)
                swapColumsSmall((int) (Math.random() * 3), (int) (Math.random() * 3), (int) (Math.random() * 3));

            if (versionChanges == 2) swapDistrictRows((int) (Math.random() * 3), (int) (Math.random() * 3));

            if (versionChanges == 3) swapDistrictColum((int) (Math.random() * 3), (int) (Math.random() * 3));

            if (versionChanges == 4) transpositionBoard();
        }
    }

    public void generateNumInGameBoard() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\code\\second_year\\javaLab\\lab3\\src\\main\\java\\ru\\nsu\\kurgin\\lab3\\sudoku\\SudokuBaseTable.txt"))) {
            for (int i = 0; i < 9; i++) {
                String readStr = reader.readLine();
                for (int k = 0; k < 9; k++)
                    finalGameBoard.get(i).set(k, Integer.valueOf(readStr.substring(k, k + 1)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param district 0-2 один из 3 райнов
     */
    public void swapRowsSmall(int district, int firstRows, int secondRows) {
        Vector<Integer> tmp = finalGameBoard.get(district * 3 + firstRows);
        finalGameBoard.set(district * 3 + firstRows, finalGameBoard.get(district * 3 + secondRows));
        finalGameBoard.set(district * 3 + secondRows, tmp);
    }

    public void swapColumsSmall(int district, int firstColum, int secondColumn) {
        for (int i = 0; i < 9; i++) {
            Integer tmp = finalGameBoard.get(i).get(district * 3 + firstColum);
            finalGameBoard.get(i).set(district * 3 + firstColum, finalGameBoard.get(i).get(district * 3 + secondColumn));
            finalGameBoard.get(i).set(district * 3 + secondColumn, tmp);
        }
    }

    public void swapDistrictRows(int firstDistrict, int secondDistrict) {
        for (int i = 0; i < 3; i++) {
            Vector<Integer> tmp = finalGameBoard.get(firstDistrict * 3 + i);
            finalGameBoard.set(firstDistrict * 3 + i, finalGameBoard.get(secondDistrict * 3 + i));
            finalGameBoard.set(secondDistrict * 3 + i, tmp);
        }
    }

    public void swapDistrictColum(int firstDistrict, int secondDistrict) {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 9; k++) {
                Integer tmp = finalGameBoard.get(k).get(i + firstDistrict * 3);
                finalGameBoard.get(k).set(firstDistrict * 3 + i, finalGameBoard.get(k).get(secondDistrict * 3 + i));
                finalGameBoard.get(k).set(secondDistrict * 3 + i, tmp);
            }
        }
    }

    public void transpositionBoard() {
        for (int i = 0; i < 9; i++) {
            for (int k = i + 1; k < 9; k++) {
                Integer tmp = finalGameBoard.get(i).get(k);
                finalGameBoard.get(i).set(k, finalGameBoard.get(k).get(i));
                finalGameBoard.get(k).set(i, tmp);
            }
        }
    }

    public void printBoard() {
        System.out.println("-----------------------------");
        for (int i = 0; i < 9; i++) {
            System.out.println(finalGameBoard.get(i));
        }
    }
}
