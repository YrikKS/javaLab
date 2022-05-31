package ru.nsu.kurgin.lab3.sudoku.momento;

public class ModifiedMainNumber {
    private boolean isMainNumberModified;
    private Integer rowWithModifiedCell;
    private Integer colWithModifiedCell;
    private Integer numberThatWasBefore;


    public ModifiedMainNumber () {
        isMainNumberModified = false;
        rowWithModifiedCell = 0;
        colWithModifiedCell = 0;
        numberThatWasBefore = 0;
    }

    public void setModifiedMainNumber(Integer row, Integer col, Integer numberInCell) {
        isMainNumberModified = true;
        rowWithModifiedCell = row;
        colWithModifiedCell = col;
        numberThatWasBefore = numberInCell;
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

}
