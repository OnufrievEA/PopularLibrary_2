package com.example.popularlibrary_2.first_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.popularlibrary_2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logBtn = findViewById(R.id.log_button);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogTask logTask = new LogTask();
                logTask.execute();
                Log.d(logTask.TAG, "onClickMethod is finished");
            }
        });

    }
}