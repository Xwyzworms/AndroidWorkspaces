package com.example.simplevideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

import com.example.simplevideoplayer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupVideoPlayer1();
        setupVideoPlayer2();
    }

    private void setupVideoPlayer1()
    {
        binding.videoView1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video_bro);
        android.widget.MediaController mc = new MediaController(this);
        mc.setAnchorView(binding.videoView1);
        binding.videoView1.setMediaController(mc);
    }

    private void setupVideoPlayer2()
    {
        Uri uri = Uri.parse("https://static.videezy.com/system/resources/previews/000/002/231/original/5226496.mp4");
        binding.videoView2.setVideoURI(uri);

        MediaController mc = new MediaController(this);
        mc.setAnchorView(binding.videoView2);
        binding.videoView2.setMediaController(mc);
        binding.videoView2.start();

    }
}