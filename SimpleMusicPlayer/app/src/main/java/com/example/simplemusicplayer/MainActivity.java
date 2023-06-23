package com.example.simplemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.simplemusicplayer.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();


    private int oneTime =0;

    private double startTime = 0;
    private double endTime = 0;
    private int forwardTime = 10000;
    private int backwardTime = 10000;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupMediaPlayer();
    }

    private void setupMediaPlayer()
    {
        mediaPlayer = MediaPlayer.create(this, R.raw.astronaut);
        binding.songTitle.setText(getResources().getIdentifier("astronaut","raw",getPackageName()));
        binding.seekBar.setClickable(false);

        binding.playBtn.setOnClickListener(v -> playMusic());

        binding.backBtn.setOnClickListener(v -> backwardMusic());

        binding.forwardBtn.setOnClickListener(v -> forwardMusic());

        binding.pauseBtn.setOnClickListener(v -> pauseMusic());

    }

    private void playMusic()
    {
        mediaPlayer.start();
        endTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();

        if(oneTime == 0)
        {
            binding.seekBar.setMax((int) endTime);
            oneTime = 1;
        }
        binding.timeLeftText.setText(parseTime(endTime));

        binding.seekBar.setProgress((int) startTime);
        handler.postDelayed(UpdateSongTime, 100);
    }

    private String parseTime(double time)
    {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) time);
        long seconds = TimeUnit.MILLISECONDS.toSeconds((long) time)  - TimeUnit.MINUTES.toSeconds(minutes);

        return String.format("%d min, %d sec",minutes, seconds);
    }
    private Runnable UpdateSongTime = new Runnable()
    {
        @Override
        public void run()
        {
            startTime = mediaPlayer.getCurrentPosition();

            binding.timeLeftText.setText(parseTime(startTime));
            binding.seekBar.setProgress((int) startTime);
            handler.postDelayed(this, 100);
        }
    };
    private void pauseMusic()
    {
        mediaPlayer.pause();
    }

    private void forwardMusic()
    {
        int temporaryTime = (int) startTime;
        if(temporaryTime + forwardTime <= endTime )
        {
            startTime += forwardTime;
            mediaPlayer.seekTo((int)startTime);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Can't Forward", Toast.LENGTH_LONG).show();
        }
    }

    private void backwardMusic()
    {
        int temporaryTime = (int) startTime;
        if(temporaryTime - backwardTime > 0)
        {
            startTime -= backwardTime;
            mediaPlayer.seekTo((int)startTime);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Can't Backward", Toast.LENGTH_LONG).show();
        }
    }
}