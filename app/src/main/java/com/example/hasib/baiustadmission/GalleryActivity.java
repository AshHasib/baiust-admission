package com.example.hasib.baiustadmission;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.hasib.baiustadmission.adapter.ViewHolder;
import com.example.hasib.baiustadmission.model.ImageModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    private List<ImageModel> imageList;
    RecyclerView imageRecycler;
    //MyAdapter adapter;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(GalleryActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(GalleryActivity.this);
        }
        builder.setTitle("Message")
                .setMessage("You need a stable internet connection(or Wifi) to watch the images")
                .setPositiveButton("GOT IT!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                }).show();


        toolbar=findViewById(R.id.galleryToolbar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Gallery");
        actionBar.setDisplayHomeAsUpEnabled(true);

        imageList=new ArrayList<>();
        imageRecycler=findViewById(R.id.imageRecycler);
        imageRecycler.setHasFixedSize(true);
        imageRecycler.setLayoutManager(new GridLayoutManager(this,2));
        reference=FirebaseDatabase.getInstance().getReference("Gallery");
    }




    //Load data into view on start


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<ImageModel,ViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<ImageModel, ViewHolder>(ImageModel.class,R.layout.list_row,ViewHolder.class,reference) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, ImageModel model, int position) {
                        viewHolder.setDetails(getApplicationContext(),model.getTitle(),model.getImage(),model.getDesc());
                    }
                };

        imageRecycler.setAdapter(firebaseRecyclerAdapter);
    }
}
