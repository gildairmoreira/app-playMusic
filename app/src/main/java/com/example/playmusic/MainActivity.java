package com.example.playmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView pause = findViewById(R.id.pause);
        ImageView play = findViewById(R.id.play);
        ImageView stop = findViewById(R.id.stop);
        mediaPlayer = MediaPlayer.create(this, R.raw.global);

        pause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        });

        play.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }

        });

        stop.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.global);
            }

        });
    }
}