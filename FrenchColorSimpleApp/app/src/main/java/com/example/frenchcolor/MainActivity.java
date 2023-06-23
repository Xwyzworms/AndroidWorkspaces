package com.example.frenchcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import com.example.frenchcolor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    // Using tag is the best stuff you do when using XML bro
    public void SayTheColor(View view)
    {
        Button btn_check = (Button) view;
        MediaPlayer mediaPlayer = MediaPlayer.create(this,
                getResources().getIdentifier(btn_check.getTag().toString(), "raw", getPackageName()));
        mediaPlayer.start();
    }


}