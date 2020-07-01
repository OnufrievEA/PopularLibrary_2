package com.example.popularlibrary_2.second_task;

import android.util.Log;

import static com.example.popularlibrary_2.second_task.SpamGenerator.TAG;

public class Subscriber implements Observer {

    public void updateData(String spamTheme, String spamText, int subscriberIndex) {
        Log.d(TAG, "Spam theme: " + spamTheme + "    spam text: " + spamText + "    subscriber index: " + Integer.toString(subscriberIndex));
    }
}
