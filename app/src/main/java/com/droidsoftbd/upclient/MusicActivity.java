package com.droidsoftbd.upclient;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    private ListView mainList;
    private MediaPlayer mp;

    private final String[] listContent = {"chimes","chord",
            "ding","notify"};
    private final ArrayList<Integer> resID = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //initializations
        mp = new MediaPlayer();
        mainList = findViewById(R.id.musivListView);
        while (!resID.isEmpty()) {
            
        }
        ArrayAdapter adapter;

        Uri uri = Uri.parse("android.resource://"+MusicActivity.this+"/raw/.mp3/");
        Log.e("musicfiles",uri.toString());
    }
}
