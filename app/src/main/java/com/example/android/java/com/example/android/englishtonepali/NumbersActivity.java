package com.example.android.englishtonepali;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_numbers);

        final ArrayList<Words> numbers = new ArrayList<Words>();
        numbers.add(new Words("एक", "one", R.drawable.number_one, R.raw.one));
        numbers.add(new Words("दुई", "two", R.drawable.number_two, R.raw.two));
        numbers.add(new Words("तीन", "three", R.drawable.number_three, R.raw.three));
        numbers.add(new Words("चार", "four", R.drawable.number_four, R.raw.four));
        numbers.add(new Words("पाच", "five", R.drawable.number_five, R.raw.five));
        numbers.add(new Words("छ", "six", R.drawable.number_six, R.raw.six));
        numbers.add(new Words("सात", "seven", R.drawable.number_seven, R.raw.seven));
        numbers.add(new Words("आठ", "eight", R.drawable.number_eight, R.raw.eight));
        numbers.add(new Words("नौ", "nine", R.drawable.number_nine, R.raw.nine));
        numbers.add(new Words("दस", "ten", R.drawable.number_ten, R.raw.ten));


        WordAdapter arrayAdapter = new WordAdapter(this, numbers, R.color.orange);
        ListView listView = (ListView) findViewById(R.id.ListNumber);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Words words = numbers.get(i);
                releasemediaPlayer();
                mediaPlayer = MediaPlayer.create(view.getContext(), words.getAudio());
                mediaPlayer.start();

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
