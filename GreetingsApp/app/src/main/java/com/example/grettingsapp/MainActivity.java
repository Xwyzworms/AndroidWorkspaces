package com.example.grettingsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.grettingsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupListener();

    }

    private void setupListener()
    {
        binding.btnGreet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String namae = binding.etYourName.getText().toString();
                if(!namae.isEmpty())
                {
                    showMessage(namae);
                }
                else
                {
                    showMessage("Please insert Your name");
                }
            }
        });
    }

    private void showMessage(String message)
    {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
    }
}