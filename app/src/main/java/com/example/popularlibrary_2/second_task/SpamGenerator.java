package com.example.popularlibrary_2.second_task;

import android.util.Log;

import java.util.ArrayList;

public class SpamGenerator implements Observable {

    public static final String TAG = "OBS_TAG";

    private ArrayList<Observer> arrayList;
    private String spamTheme;
    private String spamText;

    public SpamGenerator() {
        arrayList = new ArrayList<>();
    }

    public void generateSpamMessage(String spamTheme, String spamText){
        this.spamTheme = spamTheme;
        this.spamText = spamText;

        notifyAllObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        Log.d(TAG, "subscribe client");
        arrayList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        Log.d(TAG, "unsubscribe client");
        arrayList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        Log.d(TAG, "notifyAllSubscribers");
        for (int i = 0; i < arrayList.size(); i++) {
            Observer observer = arrayList.get(i);
            observer.updateData(spamTheme, spamText, i);
        }
    }
}
