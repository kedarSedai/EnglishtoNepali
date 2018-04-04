package com.example.android.englishtonepali;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener monCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Words> phrases = new ArrayList<Words>();
        phrases.add(new Words("नमस्ते ", "Greetings", R.raw.namaste));
        phrases.add(new Words("तिम्रो को नाम के हो  ", "What is your name ?", R.raw.timro_nam_k_ho));
        phrases.add(new Words("मेरो नाम राम हो  ", "My name is ram", R.raw.mero_nam_ram_ho));
        phrases.add(new Words("सन्चै हुनुहुन्छ ", "How are you?", R.raw.sanchai_hunuhunxa));
        phrases.add(new Words("सन्चै छु ", "I'm fine", R.raw.sanchai_xu));
        phrases.add(new Words("तपाईं कता बसनु हुन्छ ", "Where do you live ?", R.raw.tapai_kata_basnuhunxa));
        phrases.add(new Words("म काठमाडौं मा बस्छु  ", "I live in kathmandu", R.raw.mero_ghar_kathmandu_ho));
        phrases.add(new Words("म तपाईंलाई धेरै माया गर्छु ", "I luv you so much", R.raw.ma_tapalai_maya_garchu));
        phrases.add(new Words("तपाईं धेरै राम्री हुनुहुन्छ ", "You are too beautiful", R.raw.tapai_dherai_ramri_hunuhunxa));
        phrases.add(new Words("धन्यवाद ", "Thank you", R.raw.dhanybaad));

        WordAdapter adapter = new WordAdapter(this, phrases, R.color.orange);
        ListView listView = (ListView) findViewById(R.id.phrases);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Words words = phrases.get(i);
                relaseMediaPlaye();
                mediaPlayer = MediaPlayer.create(view.getContext(), words.getAudio());
                mediaPlayer.start();

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        relaseMediaPlaye();
    }

    private void relaseMediaPlaye() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }


    }

}
