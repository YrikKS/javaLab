package ru.nsu.kurgin.lab3.sudoku;

import java.util.Scanner;

public class currentCells {

    Integer numberNow;

    public void setNumberNow() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();

        System.out.printf("Your number: %d \n", num);
        in.close();
        numberNow = num;
    }
}
