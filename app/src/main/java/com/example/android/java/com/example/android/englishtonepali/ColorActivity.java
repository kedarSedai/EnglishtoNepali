package com.example.android.englishtonepali;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener monCompletionListener = new MediaPlayer.OnCompletionListener() {
       @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releasemediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        final ArrayList<Words> color = new ArrayList<Words>();
        color.add(new Words("रातो", "red", R.drawable.color_red, R.raw.rato));
        color.add(new Words("सेतो", "white", R.drawable.color_white, R.raw.seto));
        color.add(new Words("निलो", "blue", R.drawable.color_blue, R.raw.nilo));
        color.add(new Words("कालो", "black", R.drawable.color_black, R.raw.kalo));
        color.add(new Words("हरियो", "green", R.drawable.color_green, R.raw.hariyo));
        color.add(new Words("पहेलो", "yellow", R.drawable.color_yellow, R.raw.pahilo));
        color.add(new Words("चादी ", "silver", R.drawable.color_silver, R.raw.chadi));
        color.add(new Words("खैरो", "brown", R.drawable.color_brown, R.raw.khairo));
        color.add(new Words("सुन्तले", "orange", R.drawable.color_orange, R.raw.suntale));
        color.add(new Words("गुलाफी ", "pink", R.drawable.color_pink, R.raw.gulafi));

        WordAdapter colors = new WordAdapter(this, color, R.color.orange);
        ListView listView = (ListView) findViewById(R.id.colors);
        listView.setAdapter(colors);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                Words words = color.get(i);
                releasemediaPlayer();
                mediaPlayer = MediaPlayer.create(view.getContext(), words.getAudio());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(monCompletionListener);


            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releasemediaPlayer();
    }

    private void releasemediaPlayer() {
        if (mediaPlayer != null) {

            mediaPlayer.release();


            mediaPlayer = null;
        }
    }
}
