package com.example.hasib.baiustadmission;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ClubActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);


        toolbar=findViewById(R.id.clubToolBar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Clubs");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
