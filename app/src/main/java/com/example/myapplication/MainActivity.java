package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastMe(View view){
//        Toast myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT);
//        myToast.show();
        Intent showEntities = new Intent(this, DisplayRandomEntities.class);
        startActivity(showEntities);
    }

    public void countMe(View view){
        TextView showContextTextView = (TextView) findViewById(R.id.textView);
        String countString = showContextTextView.getText().toString();
        Log.d("my text", "Value: " + countString);
        Integer count = Integer.parseInt(countString);
        count++;
        Log.d("my text + 1", "Value: " + count);
        showContextTextView.setText(count.toString());
    }
    private static final String TOTAL_COUNT = "total_count";
    public void randomMe(View view){
        Intent randomIntent = new Intent(this, SecondActivity.class);
        TextView showContextTextView = (TextView) findViewById(R.id.textView);
        String countString = showContextTextView.getText().toString();
        int count = Integer.parseInt(countString);
        randomIntent.putExtra(TOTAL_COUNT, count);
        startActivity(randomIntent);
    }
}
