package com.droidsoftbd.upclient;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    private ListView mainList;
    private MediaPlayer mp;
    private ArrayList list;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //initializations
        mp = new MediaPlayer();
        mainList = findViewById(R.id.musivListView);
        Field[] mp3Fields = R.raw.class.getFields();
        list = new ArrayList();

        for (int i = 0; i < mp3Fields.length; i++) {
            list.add(mp3Fields[i].getName());
        }

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        mainList.setAdapter(adapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mp != null) {
                    mp.release();
                }
                int resourceID = getResources().getIdentifier(String.valueOf(list.get(i)),"raw",getPackageName());
                mp = MediaPlayer.create(MusicActivity.this,resourceID);
                mp.start();
            }
        });


    }

    public void pauseMusic(View view) {

        if (mp.isPlaying()) {
            mp.pause();

        } else if (mp != null){
            mp.start();
        }
    }

    public void stopMusic(View view) {
        if (mp.isPlaying()) {
            mp.stop();
        }
    }
}