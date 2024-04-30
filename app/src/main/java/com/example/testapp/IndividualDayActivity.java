package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.testapp.MainFragments.CalendarFragment;
import com.example.testapp.databinding.ActivityIndividualDayBinding;

import java.util.ArrayList;

public class IndividualDayActivity extends AppCompatActivity {
    String date;
    String year;
    TextView ddmm;
    TextView yyyy;
    TextView backButton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIndividualDayBinding binding = ActivityIndividualDayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = binding.individualDayRecycler;
//        recyclerView = findViewById(R.id.individual_day_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data list
        ArrayList<EventModel> eventList = new ArrayList<>();
        eventList.add(new EventModel("Activity 1", "0000-0100"));
        eventList.add(new EventModel("Activity 2", "0100-0200"));
        eventList.add(new EventModel("Activity 3", "0200-0300"));

        // Initialize adapter
        IndividualDayAdapter adapter = new IndividualDayAdapter(eventList);

        // Attach adapter to RecyclerView
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();
        date = String.valueOf(intent.getIntExtra("day", 0)) + "/" + String.valueOf(intent.getIntExtra("month", 0));
        year = String.valueOf(intent.getIntExtra("year", 0));
        ddmm = findViewById(R.id.date_display);
        yyyy = findViewById(R.id.year_display);
        ddmm.setText(date);
        yyyy.setText(year);
        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndividualDayActivity.this, MainActivity.class);
                intent.putExtra("from_calendar", true);
                startActivity(intent);
            }
        });
    }
}
