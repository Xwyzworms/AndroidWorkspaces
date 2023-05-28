package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.unitconverterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupListener();

    }

    private void setupListener()
    {
        binding.btnConvert.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.etConverter.getText().toString().isEmpty())
                {
                    double kgValue = Double.parseDouble(binding.etConverter.getText().toString());
                    binding.tvHasilKonversi.setText("" + kgValue*1000 + " Gram");
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Bang isi bang", Toast.LENGTH_LONG ).show();
                }
            }
        });

    }

}