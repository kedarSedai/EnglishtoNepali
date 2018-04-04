package com.example.android.englishtonepali;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2/19/2018.
 */

public class WordAdapter extends ArrayAdapter<Words> {
    private int mcolorid;

    public WordAdapter(Activity context, ArrayList<Words> words, int colorid) {

        super(context, 0, words);
        mcolorid = colorid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        Words currentword = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nepaliTextView = (TextView) listItemView.findViewById(R.id.nepali);

        nepaliTextView.setText(currentword.getNepaliWord());


        TextView EnglishTextView = (TextView) listItemView.findViewById(R.id.english);


        EnglishTextView.setText(currentword.getEnglishWord());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        if (currentword.hasImage()) {
            image.setImageResource(currentword.getImage());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }



        return listItemView;
    }
}

