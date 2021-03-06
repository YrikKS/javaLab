package ru.nsu.kurgin.lab3.sudoku.obeserver;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    List<Observer> list = new ArrayList<>();

    public void addObserver(Observer observer){
        list.add(observer);
    }

    public void notifyObservers(){
        for(Observer ob : list){
            ob.update();
        }
    }
}
