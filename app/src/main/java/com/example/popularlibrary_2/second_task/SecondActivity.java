package com.example.popularlibrary_2.second_task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.popularlibrary_2.R;

public class SecondActivity extends AppCompatActivity {

    private SpamGenerator spamGenerator = new SpamGenerator();
    private Subscriber subscriber = new Subscriber();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button subscribeBtn = findViewById(R.id.subscribe_button);
        Button unsubscribeBtn = findViewById(R.id.unsubscribe_button);
        Button spamBtn = findViewById(R.id.spam_button);
        subscribeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spamGenerator.subscribe(subscriber);
            }
        });
        unsubscribeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spamGenerator.unsubscribe(subscriber);
            }
        });
        spamBtn.setOnClickListener(new View.OnClickListener() {
            int message_nubmer = 1;
            @Override
            public void onClick(View v) {
                spamGenerator.generateSpamMessage(String.format("SpamTheme_%d", message_nubmer), String.format("SpamText_%d", message_nubmer));
                message_nubmer++;
            }
        });

    }
}