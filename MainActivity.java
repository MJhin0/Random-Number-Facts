package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchFacts(View view) {

        EditText mStart = findViewById(R.id.numberInput1);
        String start = mStart.getText().toString();
        int limit1 = 0;
        if (!"".equals(start)){
            limit1 = Integer.parseInt(start);
        }

        EditText mEnd = findViewById(R.id.numberInput2);
        String end = mEnd.getText().toString();
        int limit2 = 0;
        if (!"".equals(end)){
            limit2 = Integer.parseInt(end);
        }

        Intent intent = new Intent(MainActivity.this, NumbersDetailActivity.class);
        intent.putExtra("start", limit1);
        intent.putExtra("end", limit2);

        startActivity(intent);
    }


}