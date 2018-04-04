package com.example.android.englishtonepali;

/**
 * Created by user on 2/19/2018.
 */

public class Words {
    private String mNepaliWord;
    private String mEnglishWord;
    private int mImage = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudio;


    public Words(String nepali, String english, int image, int audiofile) {
        mNepaliWord = nepali;
        mEnglishWord = english;
        mImage = image;
        mAudio = audiofile;
    }

    public Words(String nepali, String english, int audiofile) {
        mNepaliWord = nepali;
        mEnglishWord = english;
        mAudio = audiofile;
    }

    public String getNepaliWord() {
        return mNepaliWord;
    }

    public String getEnglishWord() {
        return mEnglishWord;

    }

    public int getImage() {
        return mImage;
    }


    public boolean hasImage() {
        return mImage != NO_IMAGE_PROVIDED;
    }

    public int getAudio() {
        return mAudio;
    }
}
