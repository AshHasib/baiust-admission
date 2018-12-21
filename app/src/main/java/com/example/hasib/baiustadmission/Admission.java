package com.example.hasib.baiustadmission;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.Adapter;

/**
 * Activity that handles Admission tasks
 * */


public class Admission extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    private CardView feeStructure,applyInfo,announcement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        toolbar=findViewById(R.id.admissionToolbar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Admission");
        actionBar.setDisplayHomeAsUpEnabled(true);



        feeStructure=findViewById(R.id.cardFeeStructure);
        feeStructure.setOnClickListener(v->{
            startActivity(new Intent(Admission.this,FeeStructure.class));
        });

        applyInfo=findViewById(R.id.cardApplyInstructions);
        applyInfo.setOnClickListener(v->{
            startActivity(new Intent(Admission.this,ApplyInfo.class));
        });

        announcement=findViewById(R.id.cardAnnouncement);
        announcement.setOnClickListener(v->{
            startActivity(new Intent(Admission.this,Announcement.class));
        });

    }
}
