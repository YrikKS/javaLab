package ru.nsu.kurgin.lab5.chat.client.observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableChat {
    List<ObserverChat> list = new ArrayList<>();

    public void addObserver(ObserverChat observer){
        list.add(observer);
    }

    public void removeObserver(ObserverChat observer){
        list.remove(observer);
    }

    public void notifyOfUpdateObserverChat(String msg){
        for(ObserverChat ob : list){
            ob.updateChat(msg);
        }
    }

    public void notifyOfUpdateObserverMember(String stingMember){
        for(ObserverChat ob : list){
            ob.updateMember(stingMember);
        }
    }

    public void notifyOfSetObserverMember(String stingMember){
        for(ObserverChat ob : list){
            ob.setMember(stingMember);
        }
    }

}
