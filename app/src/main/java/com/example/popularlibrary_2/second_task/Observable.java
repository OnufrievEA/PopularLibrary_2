package com.example.popularlibrary_2.second_task;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyAllObservers();
}
