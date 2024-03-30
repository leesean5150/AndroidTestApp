package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class IndividualDayActivity extends AppCompatActivity {
    String date;
    String year;
    TextView ddmm;
    TextView yyyy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_day);
        Intent intent = getIntent();
        date = String.valueOf(intent.getIntExtra("day", 0)) + "/" + String.valueOf(intent.getIntExtra("month", 0));
        year = String.valueOf(intent.getIntExtra("year", 0));
        ddmm = findViewById(R.id.date_display);
        yyyy = findViewById(R.id.year_display);
        ddmm.setText(date);
        yyyy.setText(year);
    }
}