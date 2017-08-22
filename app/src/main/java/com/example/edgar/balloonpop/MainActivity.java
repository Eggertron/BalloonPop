package com.example.edgar.balloonpop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = (Button)findViewById(R.id.startButton);
        startBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //starting game activity
        startActivity(new Intent(this, GameActivity.class));
    }
}
