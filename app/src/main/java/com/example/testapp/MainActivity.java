package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.testapp.MainFragments.CalendarFragment;
import com.example.testapp.MainFragments.HomeFragment;
import com.example.testapp.MainFragments.ProfileFragment;
import com.example.testapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {
    Button plusButton;
    public ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        plusButton = findViewById(R.id.debugAddEventButton);
        Intent intent = getIntent();
        boolean fromCalendar = intent.getBooleanExtra("from_calendar", false);
        if (fromCalendar) {
            replaceFragment(new CalendarFragment());
            binding.bottomNavigationView.setSelectedItemId(R.id.CalendarNav);
        } else {
            replaceFragment(new HomeFragment());
        }
        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.HomeNav) {
                    replaceFragment(new HomeFragment());
                } else if (itemId == R.id.CalendarNav) {
                    replaceFragment(new CalendarFragment());
                } else if (itemId == R.id.ProfileNav) {
                    replaceFragment(new ProfileFragment());
                } else {
                    return false;
                }
                return true;
            }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}