package com.example.android.englishtonepali;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sending intent to NumbersActivity

        TextView textView = (TextView) findViewById(R.id.numbers);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);

            }
        });

        TextView textView1 = (TextView) findViewById(R.id.phrases);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(intent);
            }
        });

        TextView textView2 = (TextView) findViewById(R.id.familymembers);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);
            }
        });

        TextView textView3 = (TextView) findViewById(R.id.colors);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                startActivity(intent);
            }
        });


    }


}
