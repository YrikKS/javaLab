package ru.nsu.kurgin.lab5.chat.client.observer;

public interface ObserverChat{
    void update();
    void updateChat(String msg);
    void updateMember(String stringMembers);
    void setMember(String stringMembers);
}
