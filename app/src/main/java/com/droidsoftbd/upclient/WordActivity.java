package com.droidsoftbd.upclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
    }

    public void refreshList(View view) {

    }

    public void goToMusics(View view) {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
