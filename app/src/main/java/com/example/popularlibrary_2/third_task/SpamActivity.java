package com.example.popularlibrary_2.third_task;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.popularlibrary_2.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SpamActivity extends AppCompatActivity {

    private static final String TAG = "SpamActivity";

    private SpamPresenter spamPresenter;
    private Observable<String> observable;
    private Disposable disposable;

    private Button subscribeBtn;
    private Button unsubscribeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        initView();

        spamPresenter = new SpamPresenter();
        observable = spamPresenter.getSpam();
    }

    private void initView() {
        subscribeBtn = findViewById(R.id.subscribe_button);
        subscribeBtn.setOnClickListener(subscribeBtnClickListener);

        unsubscribeBtn = findViewById(R.id.unsubscribe_button);
        unsubscribeBtn.setOnClickListener(unsubscribeBtnClickListener);
    }

    View.OnClickListener subscribeBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            subscribe(v);
        }
    };

    public void subscribe(View view) {
        observable.subscribe(new Observer<String>() {

            @Override
            public void onSubscribe(Disposable disposable) {
                Log.d(TAG, "onSubscribe: ");
                SpamActivity.this.disposable = disposable;
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }


    View.OnClickListener unsubscribeBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            unsubscribe(v);
        }
    };

    public void unsubscribe(View view) {
        disposable.dispose();
    }
}