package ru.nsu.kurgin.lab3.sudoku.momento;

public class ModifiedVersionNumber {
    private boolean isVersionNumberModified = false;
    private Integer rowWithModifiedCell = 0;
    private Integer colWithModifiedCell = 0;
    private Integer numberThatWasBefore = 0;
    private Integer numberThatBecame = 0;
    private Integer positionVersion = 0;

    public ModifiedVersionNumber(Integer row, Integer col, Integer positionVersion, Integer numberInCell, Integer numberThatBecame) {
        isVersionNumberModified = true;
        rowWithModifiedCell = row;
        colWithModifiedCell = col;
        numberThatWasBefore = numberInCell;
        this.positionVersion = positionVersion;
        this.numberThatBecame = numberThatBecame;
    }

    public Integer getColWithModifiedCell() {
        return colWithModifiedCell;
    }

    public Integer getRowWithModifiedCell() {
        return rowWithModifiedCell;
    }

    public Integer getNumberThatWasBefore() {
        return numberThatWasBefore;
    }

    public Integer getPositionVersion() {
        return positionVersion;
    }

}
