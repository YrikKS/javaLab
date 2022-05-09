package ru.nsu.kurgin.lab5.chat.client.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    List<Observer> list = new ArrayList<>();

    public void addObserver(Observer observer){
        list.add(observer);
    }

    public void removeObserver(Observer observer){
        list.remove(observer);
    }

    public void notifyObservers(){
        for(Observer ob : list){
            ob.update();
        }
    }
}
