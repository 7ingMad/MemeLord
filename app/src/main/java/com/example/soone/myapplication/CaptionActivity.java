package com.example.soone.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

public class CaptionActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener{

    @Override
    public void createMeme(String top, String bottom) {
        BotPictureFragment botPictureFragment = (BotPictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        botPictureFragment.setMemeText(top, bottom);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caption_activity);
    }
}
