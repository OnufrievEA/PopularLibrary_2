package com.example.popularlibrary_2.third_task;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class SpamPresenter {
    private static final String TAG = "SpamPresenter";


    public Observable<String> getSpam() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 5; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String spamMessage = "spam_message: " + i;
                        Log.d(TAG, "getSpam: " + Thread.currentThread().getName() + ": " + spamMessage);
                        emitter.onNext(spamMessage);
                    }

                    emitter.onComplete();

                } catch (InterruptedException e) {
                    Log.d(TAG, "getSpam: not disposed");
                }
            }
        }).subscribeOn(Schedulers.io());

        return observable;
    }
}
