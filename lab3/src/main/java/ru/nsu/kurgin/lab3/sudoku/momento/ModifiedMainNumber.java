package ru.nsu.kurgin.lab3.sudoku.momento;

public class ModifiedMainNumber {
    private boolean isMainNumberModified;
    private Integer rowWithModifiedCell;
    private Integer colWithModifiedCell;
    private Integer numberThatWasBefore;
    private Integer numberThatBecame;


    public ModifiedMainNumber () {
        isMainNumberModified = false;
        rowWithModifiedCell = 0;
        colWithModifiedCell = 0;
        numberThatWasBefore = 0;
        numberThatBecame = 0;
    }

    public ModifiedMainNumber(Integer row, Integer col, Integer numberInCell) {
        isMainNumberModified = true;
        rowWithModifiedCell = row;
        colWithModifiedCell = col;
        numberThatWasBefore = numberInCell;
    }

    public void setModifiedMainNumber(Integer row, Integer col, Integer numberInCell, Integer numberThatBecame) {
        isMainNumberModified = true;
        rowWithModifiedCell = row;
        colWithModifiedCell = col;
        numberThatWasBefore = numberInCell;
        this.numberThatBecame = numberThatBecame;
    }

    public boolean isMainNumberModified() {
        return isMainNumberModified;
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

    public Integer getNumberThatBecame() {
        return numberThatBecame;
    }
}
