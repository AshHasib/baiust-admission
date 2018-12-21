package com.example.hasib.baiustadmission;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class FullImageActivity extends AppCompatActivity {
    CircularProgressDrawable circularProgressDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();

        TextView title=findViewById(R.id.title);
        TextView desc=findViewById(R.id.desc);


        ImageView fullImage=findViewById(R.id.fullImg);
        String uri=extras.getString("img");

        circularProgressDrawable=new CircularProgressDrawable(FullImageActivity.this);
        circularProgressDrawable.setStrokeWidth(10f);
        circularProgressDrawable.setCenterRadius(60f);
        circularProgressDrawable.setColorSchemeColors(Color.WHITE);


        Picasso.get().load(uri).placeholder(circularProgressDrawable).into(fullImage);
        title.setText(extras.getString("title"));
        desc.setText(extras.getString("desc"));

        PhotoViewAttacher pAttacher;
        pAttacher = new PhotoViewAttacher(fullImage);
        pAttacher.update();

    }
}
