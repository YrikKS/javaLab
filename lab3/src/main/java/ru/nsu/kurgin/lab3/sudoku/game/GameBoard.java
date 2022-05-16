package ru.nsu.kurgin.lab3.sudoku.game;


import ru.nsu.kurgin.lab3.sudoku.Constants;
import ru.nsu.kurgin.lab3.sudoku.momento.ModifiedMainNumber;
import ru.nsu.kurgin.lab3.sudoku.momento.ModifiedVersionNumber;
import ru.nsu.kurgin.lab3.sudoku.momento.Momento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameBoard {

    private Vector<Vector<Integer>> gameBoard;
    private Vector<Vector<Integer>> correctGameBoard;
    private Vector<Vector<Vector<Integer>>> versionInCells;
    private Vector<Vector<Integer>> finalBoardWithOutNewNumber;
    private final List<Momento> moments = new ArrayList<>();
    private Integer positionOnList = 0;
    private Integer numberOfEmptyCells = 0;

    public void loadMomento() {
        if (moments.size() == Constants.SIZE_STACK_MOMENT_IS_ZERO || positionOnList - 1 < 0) {
            return;
        }
        if (moments.size() < positionOnList - 1)
            return;
        positionOnList--;
        Momento moment = moments.get(positionOnList);
        ModifiedMainNumber modifiedMainNumber = moment.getModifiedMainNumber();
        if (modifiedMainNumber.isMainNumberModified()) {
            gameBoard.get(modifiedMainNumber.getRowWithModifiedCell()).set(modifiedMainNumber.getColWithModifiedCell(), modifiedMainNumber.getNumberThatWasBefore());
            numberOfEmptyCells++;
        }
        Vector<ModifiedVersionNumber> vectorModifiedVersionNumber = moment.getVectorModifiedVersionNumber();

        for (int i = 0; i < vectorModifiedVersionNumber.size(); i++) {
            ModifiedVersionNumber modifiedVersionNumber = vectorModifiedVersionNumber.get(i);
            versionInCells.get(modifiedVersionNumber.getRowWithModifiedCell())
                    .get(modifiedVersionNumber.getColWithModifiedCell()).set(modifiedVersionNumber.getPositionVersion(), modifiedVersionNumber.getNumberThatWasBefore());
        }

    }

    public Integer getFinalGameBoardCell(Integer row, Integer col) {
        return gameBoard.get(row).get(col);
    }

    public boolean isCellHaveNameInStartedBoard(Integer row, Integer col) {
        if (finalBoardWithOutNewNumber.get(row).get(col) == 0)
            return false;
        return true;
    }

    public void dellAllVersionInCell(Integer row, Integer col) {
        checkMomento();
        Momento momento = new Momento();
        for (int i = 0; i < Constants.SIZE_FIELD; i++) {
            momento.addVersionInVector(row, col, versionInCells.get(row).get(col).get(i), i, 0);
            versionInCells.get(row).get(col).set(i, 0);
        }
        moments.add(momento);
        positionOnList++;
    }

    public void dellOneVersionInCell(Integer row, Integer col, Integer versionNum) {
        checkMomento();
        Momento momento = new Momento();
        momento.addVersionInVector(row, col, versionNum, versionNum, 0);
        versionInCells.get(row).get(col).set(versionNum, 0);
        moments.add(momento);
        positionOnList++;
    }

    public void setOneVersionInCell(Integer row, Integer col, Integer versionNum) {
        checkMomento();
        Momento momento = new Momento();
        momento.addVersionInVector(row, col, 0, versionNum, versionNum);
        versionInCells.get(row).get(col).set(versionNum, versionNum);
        moments.add(momento);
        positionOnList++;
    }

    public void dellNumbInCell(Integer row, Integer col) {
        checkMomento();
        numberOfEmptyCells++;
        Momento momento = new Momento();
        momento.addModifedMainNumber(row, col, gameBoard.get(row).get(col), 0);
        gameBoard.get(row).set(col, 0);
        moments.add(momento);
        positionOnList++;
    }

    public boolean isGameEnd() {
        if (numberOfEmptyCells == 0)
            return true;
        return false;
    }

    public void setNumberInCell(Integer row, Integer col, Integer num) {
        numberOfEmptyCells--;
        checkMomento();
        Momento momento = new Momento();
        momento.addModifedMainNumber(row, col, gameBoard.get(row).get(col), num);
        gameBoard.get(row).set(col, num);

        for (int k = 0; k < Constants.SIZE_FIELD; k++) {
            int passageThroughSquare = 0;
            if (k < Constants.FIRST_ROWS_IN_SMALL_SQUARE) passageThroughSquare = 0;
            if (k >= Constants.FIRST_ROWS_IN_SMALL_SQUARE && k < Constants.SECOND_ROWS_IN_SMALL_SQUARE) passageThroughSquare = 1;
            if (k >= Constants.SECOND_ROWS_IN_SMALL_SQUARE) passageThroughSquare = 2;
            if (versionInCells.get(row).get(k).get(num) == (num)) {
                versionInCells.get(row).get(k).set(num, 0);
                momento.addVersionInVector(row, k, num, num, 0);
            }
            if (versionInCells.get(k).get(col).get(num) == (num)) {
                versionInCells.get(k).get(col).set(num, 0);
                momento.addVersionInVector(k, col, num, num, 0);
            }

            if (versionInCells.get(row / Constants.SIZE_SMALL_SQUARE * Constants.SIZE_SMALL_SQUARE + k % Constants.SIZE_SMALL_SQUARE)
                    .get(col / Constants.SIZE_SMALL_SQUARE * Constants.SIZE_SMALL_SQUARE + passageThroughSquare).get(num) == (num)) {
                versionInCells.get(row / Constants.SIZE_SMALL_SQUARE * Constants.SIZE_SMALL_SQUARE + k % Constants.SIZE_SMALL_SQUARE).
                        get(col / Constants.SIZE_SMALL_SQUARE * Constants.SIZE_SMALL_SQUARE + passageThroughSquare).set(num, 0);
                momento.addVersionInVector(row / Constants.SIZE_SMALL_SQUARE * Constants.SIZE_SMALL_SQUARE + k % Constants.SIZE_SMALL_SQUARE,
                        col / Constants.SIZE_SMALL_SQUARE * Constants.SIZE_SMALL_SQUARE + passageThroughSquare, num, num, 0);
            }
            if (versionInCells.get(row).get(col).get(k + 1) != 0 && versionInCells.get(row).get(col).get(k + 1) != null)
                momento.addVersionInVector(row, col, k + 1, k + 1, k + 1);
            versionInCells.get(row).get(col).set(k + 1, 0);
        }
        moments.add(momento);
        positionOnList++;
    }

    private void checkMomento() {
        while (moments.size() != positionOnList) {
            moments.remove(moments.size() - 1);
        }
    }

    public Vector<Integer> getVersionCell(Integer row, Integer col) {
        return versionInCells.get(row).get(col);
    }

    public Integer getMainNum(Integer row, Integer col) {
        return gameBoard.get(row).get(col);
    }

    public Integer getCorrectNumberForCell(Integer row, Integer col) {
        return correctGameBoard.get(row).get(col);
    }

    public GameBoard() {
        generateGameBoard();
    }


    private void generateGameBoard() {
        gameBoard = new Vector();
        gameBoard.setSize(Constants.SIZE_FIELD);
        correctGameBoard = new Vector<>();
        correctGameBoard.setSize(Constants.SIZE_FIELD);
        finalBoardWithOutNewNumber = new Vector();
        finalBoardWithOutNewNumber.setSize(Constants.SIZE_FIELD);

        for (int i = 0; i < Constants.SIZE_FIELD; ++i) {
            gameBoard.set(i, new Vector());
            gameBoard.get(i).setSize(Constants.SIZE_FIELD);
            correctGameBoard.set(i, new Vector());
            correctGameBoard.get(i).setSize(Constants.SIZE_FIELD);
            finalBoardWithOutNewNumber.set(i, new Vector());
            finalBoardWithOutNewNumber.get(i).setSize(Constants.SIZE_FIELD);
        }

        generateNumInGameBoard();
        changesRandomGameBoard();
        for (int i = 0; i < Constants.SIZE_FIELD; ++i) {
            for (int j = 0; j < Constants.SIZE_FIELD; ++j) {
                correctGameBoard.get(i).set(j, gameBoard.get(i).get(j));
            }
        }

        for (int i = 0; i < Constants.SIZE_FIELD; ++i) {
            for (int j = 0; j < Constants.SIZE_FIELD; ++j) {
                this.deleteCells(i, j);
            }
        }

        versionInCells = new Vector();
        versionInCells.setSize(Constants.SIZE_FIELD);

        for (int i = 0; i < Constants.SIZE_FIELD; ++i) {
            versionInCells.set(i, new Vector());
            versionInCells.get(i).setSize(Constants.SIZE_FIELD);

            for (int j = 0; j < Constants.SIZE_FIELD; ++j) {
                versionInCells.get(i).set(j, new Vector());
                versionInCells.get(i).get(j).setSize(Constants.SIZE_VECTOR_MARK);
            }
        }

        createVersionInCell();

        for (int i = 0; i < Constants.SIZE_FIELD; ++i) {
            for (int j = 0; j < Constants.SIZE_FIELD; ++j) {
                finalBoardWithOutNewNumber.get(i).set(j, gameBoard.get(i).get(j));
            }
        }
    }

    public void createVersionInCell() {
        for (int i = 0; i < Constants.SIZE_FIELD; i++)
            for (int j = 0; j < Constants.SIZE_FIELD; j++) {

                if (gameBoard.get(i).get(j) == 0) {
                    boolean numCanPlaceInCells = false;
                    for (int num = 1; num < Constants.SIZE_VECTOR_MARK; num++) {
                        for (int k = 0; k < Constants.SIZE_FIELD; k++) {
                            int passageThroughSquare = 0;
                            if (k < Constants.FIRST_ROWS_IN_SMALL_SQUARE) passageThroughSquare = 0;
                            if (k >= Constants.FIRST_ROWS_IN_SMALL_SQUARE && k < Constants.SECOND_ROWS_IN_SMALL_SQUARE) passageThroughSquare = 1;
                            if (k >= Constants.SECOND_ROWS_IN_SMALL_SQUARE) passageThroughSquare = 2;
                            if (gameBoard.get(i).get(k) == num || gameBoard.get(k).get(j) == num || gameBoard.get(i / Constants.SIZE_SMALL_SQUARE * Constants.SIZE_SMALL_SQUARE + k % Constants.SIZE_SMALL_SQUARE)
                                    .get(j / Constants.SIZE_SMALL_SQUARE * Constants.SIZE_SMALL_SQUARE + passageThroughSquare) == num) {
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

    public boolean isCorrectGameEnd() {
        for (int i = 0; i < Constants.SIZE_FIELD; i++) {
            for (int j = 0; j < Constants.SIZE_FIELD; j++) {
                if (gameBoard.get(i).get(j) != correctGameBoard.get(i).get(j))
                    return false;
            }
        }
        return true;
    }

    public void dellVersionInCell() {
        for (int i = 0; i < Constants.SIZE_FIELD; i++) {
            for (int j = 0; j < Constants.SIZE_FIELD; j++) {
                for (int num = 1; num < Constants.SIZE_VECTOR_MARK; num++)
                    versionInCells.get(i).get(j).set(num, 0);
            }
        }
    }

    public void deleteCells(int k1, int k2) {
        int i, j, b, c;
        int temp = gameBoard.get(k1).get(k2);
        int count = Constants.SIZE_FIELD;
        for (i = 1; i <= Constants.SIZE_FIELD; i++) {
            int flag = 1;
            for (j = 0; j < Constants.SIZE_FIELD; j++) {
                if (j != k2) {
                    if (i != gameBoard.get(k1).get(j)) {
                        continue;
                    } else {
                        flag = 0;
                        break;
                    }
                }
            }
            if (flag == 1) {
                for (c = 0; c < Constants.SIZE_FIELD; c++) {
                    if (c != k1) {
                        if (i != gameBoard.get(c).get(k2)) {
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
                            if (i != gameBoard.get(c).get(b)) continue;
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
            gameBoard.get(k1).set(k2, 0);
            numberOfEmptyCells++;
            count--;
        }

    }

    private void changesRandomGameBoard() {
        for (int i = 0; i < Constants.NUMBER_OF_RANDOM_CHANGES; i++) {
            int versionChanges = (int) (Math.random() * 5);
            if (versionChanges == Constants.RAND_NUMB_SWAP_ROWS_SMALL)
                swapRowsSmall((int) (Math.random() * Constants.SIZE_SMALL_SQUARE), (int) (Math.random() * Constants.SIZE_SMALL_SQUARE), (int) (Math.random() * Constants.SIZE_SMALL_SQUARE));

            if (versionChanges == Constants.RAND_NUMB_SWAP_COLUMS_SMALL)
                swapColumsSmall((int) (Math.random() * Constants.SIZE_SMALL_SQUARE), (int) (Math.random() * Constants.SIZE_SMALL_SQUARE), (int) (Math.random() * Constants.SIZE_SMALL_SQUARE));

            if (versionChanges == Constants.RAND_NUMB_SWAP_DISTRICT_ROWS) swapDistrictRows((int) (Math.random() * Constants.SIZE_SMALL_SQUARE), (int) (Math.random() * Constants.SIZE_SMALL_SQUARE));

            if (versionChanges == Constants.RAND_NUMB_SWAP_DISTRICT_COLUMS) swapDistrictColum((int) (Math.random() * Constants.SIZE_SMALL_SQUARE), (int) (Math.random() * Constants.SIZE_SMALL_SQUARE));

            if (versionChanges == Constants.RAND_NUMB_TRANSPOSITION_BOARD) transpositionBoard();
        }
    }

    public void generateNumInGameBoard() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.PATH_TO_BASE_BOARD ))) {
            for (int i = 0; i < Constants.SIZE_FIELD; i++) {
                String readStr = reader.readLine();
                for (int k = 0; k < Constants.SIZE_FIELD; k++)
                    gameBoard.get(i).set(k, Integer.valueOf(readStr.substring(k, k + 1)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param district 0-2 один из 3 райнов
     */
    public void swapRowsSmall(Integer district, Integer firstRows, Integer secondRows) {
        Vector<Integer> tmp = gameBoard.get(district * Constants.SIZE_SMALL_SQUARE + firstRows);
        gameBoard.set(district * Constants.SIZE_SMALL_SQUARE + firstRows, gameBoard.get(district * Constants.SIZE_SMALL_SQUARE + secondRows));
        gameBoard.set(district * Constants.SIZE_SMALL_SQUARE + secondRows, tmp);
    }

    public void swapColumsSmall(Integer district, Integer firstColum, Integer secondColumn) {
        for (int i = 0; i < Constants.SIZE_FIELD; i++) {
            Integer tmp = gameBoard.get(i).get(district * Constants.SIZE_SMALL_SQUARE + firstColum);
            gameBoard.get(i).set(district * Constants.SIZE_SMALL_SQUARE + firstColum, gameBoard.get(i).get(district * Constants.SIZE_SMALL_SQUARE + secondColumn));
            gameBoard.get(i).set(district * Constants.SIZE_SMALL_SQUARE + secondColumn, tmp);
        }
    }

    public void swapDistrictRows(Integer firstDistrict, Integer secondDistrict) {
        for (int i = 0; i < Constants.SIZE_SMALL_SQUARE; i++) {
            Vector<Integer> tmp = gameBoard.get(firstDistrict * Constants.SIZE_SMALL_SQUARE + i);
            gameBoard.set(firstDistrict * Constants.SIZE_SMALL_SQUARE + i, gameBoard.get(secondDistrict * Constants.SIZE_SMALL_SQUARE + i));
            gameBoard.set(secondDistrict * Constants.SIZE_SMALL_SQUARE + i, tmp);
        }
    }

    public void swapDistrictColum(Integer firstDistrict, Integer secondDistrict) {
        for (int i = 0; i < Constants.SIZE_SMALL_SQUARE; i++) {
            for (int k = 0; k < Constants.SIZE_FIELD; k++) {
                Integer tmp = gameBoard.get(k).get(i + firstDistrict * Constants.SIZE_SMALL_SQUARE);
                gameBoard.get(k).set(firstDistrict * Constants.SIZE_SMALL_SQUARE + i, gameBoard.get(k).get(secondDistrict * Constants.SIZE_SMALL_SQUARE + i));
                gameBoard.get(k).set(secondDistrict * Constants.SIZE_SMALL_SQUARE + i, tmp);
            }
        }
    }

    public void transpositionBoard() {
        for (int i = 0; i < Constants.SIZE_FIELD; i++) {
            for (int k = i + 1; k < Constants.SIZE_FIELD; k++) {
                Integer tmp = gameBoard.get(i).get(k);
                gameBoard.get(i).set(k, gameBoard.get(k).get(i));
                gameBoard.get(k).set(i, tmp);
            }
        }
    }

    public void printBoard() {
        System.out.println("-----------------------------");
        for (int i = 0; i < Constants.SIZE_FIELD; i++) {
            System.out.println(gameBoard.get(i));
        }
    }

    public void printCorrectBoard() {
        System.out.println("-----------------------------");
        for (int i = 0; i < Constants.SIZE_FIELD; i++) {
            System.out.println(correctGameBoard.get(i));
        }
    }
}
