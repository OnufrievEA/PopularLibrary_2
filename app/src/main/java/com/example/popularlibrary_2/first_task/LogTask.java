package com.example.popularlibrary_2.first_task;

import android.os.AsyncTask;
import android.util.Log;

public class LogTask extends AsyncTask<Void, Void, Void> {

    public String TAG = "LogTask";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread().getName());
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                Log.d(TAG, "doInBackground: " + Thread.currentThread().getName() + ": " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread().getName());
    }
}
