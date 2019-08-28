package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showRandomNumber();
    }

    private static final String TOTAL_COUNT = "total_count";
    public void showRandomNumber(){
        Integer count = getIntent().getIntExtra(TOTAL_COUNT, 0);
        Log.d("count in second activit", "value " + count);
        // Get the text view where the random number will be displayed
        TextView randomView = findViewById(R.id.textview_random);
        // Get the text view where the heading is displayed
        TextView headingView = findViewById(R.id.textview_label);
        Log.d("random numb view", "value: " + randomView);
        Random random = new Random();
        Integer randomInt = 0;
        if(count > 0){
            randomInt = random.nextInt(count);
            Log.d("random numb", "value: " + randomInt);
        }

        randomView.setText(randomInt.toString());
        headingView.setText(getString(R.string.random_heading, count));
    }

}
