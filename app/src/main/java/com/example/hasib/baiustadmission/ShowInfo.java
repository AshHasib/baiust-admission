package com.example.hasib.baiustadmission;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;


/**
 * Showing information of admin branch
 * */

public class ShowInfo extends AppCompatActivity {
    Toolbar toolbar;
    CardView cardHead,cardDesc;

    TextView name,desig,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        toolbar=findViewById(R.id.infoToolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Information");
        actionBar.setDisplayHomeAsUpEnabled(true);


        cardHead=findViewById(R.id.cardHead);
        cardDesc=findViewById(R.id.cardDesc);

        Animation animation=new AlphaAnimation(0,1);
        animation.setDuration(750);
        cardHead.setAnimation(animation);
        cardDesc.setAnimation(animation);



        name=findViewById(R.id.txtName);
        desc=findViewById(R.id.txtDescription);
        desig=findViewById(R.id.txtDesignation);


        Bundle extras=getIntent().getExtras();

        if(extras!=null) {
            name.setText(extras.getString("Title"));
            desig.setText(extras.getString("Designation"));
            desc.setText(extras.getString("Description"));
        }


    }
}
