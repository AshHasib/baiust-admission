package com.example.hasib.baiustadmission;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;


public class Announcement extends AppCompatActivity {


    private Toolbar toolbar;
    private ActionBar actionBar;
    ImageView im1,im2,im3,im4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);


        toolbar=findViewById(R.id.announcementToolbar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Announcement");
        actionBar.setDisplayHomeAsUpEnabled(true);


        im1=findViewById(R.id.im1);
        im2=findViewById(R.id.im2);
        im3=findViewById(R.id.im3);
        im4=findViewById(R.id.im4);

        PhotoViewAttacher p1=new PhotoViewAttacher(im1);
        PhotoViewAttacher p2=new PhotoViewAttacher(im2);
        PhotoViewAttacher p3=new PhotoViewAttacher(im3);
        PhotoViewAttacher p4=new PhotoViewAttacher(im4);
        p1.update();
        p2.update();
        p3.update();
        p4.update();
    }
}
