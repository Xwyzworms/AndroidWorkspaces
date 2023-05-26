package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setOnClickListener();

    }

    private void setOnClickListener () {
        binding.btnCounter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.tvCounter.setText(""+increaseCounter());
            }
        });

    }

    private int increaseCounter()
    {
        return ++counter;
    }
}