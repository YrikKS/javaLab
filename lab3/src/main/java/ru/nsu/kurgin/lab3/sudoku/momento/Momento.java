package ru.nsu.kurgin.lab3.sudoku.momento;

import java.util.Vector;

public class Momento {
    private ModifiedMainNumber modifiedMainNumber = new ModifiedMainNumber();
    private Vector<ModifiedVersionNumber> vectorModifiedVersionNumber = new Vector<>();
    public Momento() {}

    public void addModifedMainNumber(Integer row, Integer col, Integer num, Integer newNum){
        modifiedMainNumber.setModifiedMainNumber(row, col, num);
    }

    public void addVersionInVector(Integer row, Integer col, Integer versionNum, Integer positionNum, Integer newVersionNum) {
        vectorModifiedVersionNumber.add(new ModifiedVersionNumber(row, col, positionNum, versionNum, newVersionNum));
    }

    public ModifiedMainNumber getModifiedMainNumber() {
        return modifiedMainNumber;
    }

    public Vector<ModifiedVersionNumber> getVectorModifiedVersionNumber() {
        return vectorModifiedVersionNumber;
    }
}
