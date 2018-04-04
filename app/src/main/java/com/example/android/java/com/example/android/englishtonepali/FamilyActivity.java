package com.example.android.englishtonepali;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_family);

        final ArrayList<Words> family = new ArrayList<Words>();
        family.add(new Words("हजुरबुवा ", "Grand Father", R.drawable.family_grandfather, R.raw.hajurbuwa));
        family.add(new Words("हजुरआमा ", "Grand Mother ", R.drawable.family_grandmother, R.raw.hajuraama));
        family.add(new Words("बुवा ", "Father", R.drawable.family_father, R.raw.buwa));
        family.add(new Words("आमा", "Mother", R.drawable.family_mother, R.raw.aama));
        family.add(new Words("दाई ", "Big Brother", R.drawable.family_older_brother, R.raw.dai));
        family.add(new Words("भाई", "Small Brother ", R.drawable.family_younger_brother, R.raw.bhai));
        family.add(new Words("दिदि ", "Big Sister", R.drawable.family_older_sister, R.raw.didi));
        family.add(new Words("बहिनि ", "Small Sister ", R.drawable.family_younger_sister, R.raw.bahini));
        family.add(new Words("अतिथि", "guest", R.drawable.guest, R.raw.aatithi));


        final WordAdapter families = new WordAdapter(this, family, R.color.orange);
        ListView list = (ListView) findViewById(R.id.family);
        list.setAdapter(families);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Words words = family.get(i);
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
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {

            mediaPlayer.release();


            mediaPlayer = null;
        }
    }
}