package com.example.hasib.baiustadmission.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hasib.baiustadmission.FullImageActivity;
import com.example.hasib.baiustadmission.R;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    View view;
    CircularProgressDrawable circularProgressDrawable;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        view=itemView;
    }

    public void setDetails(Context context,String title,String uri,String desc){
        //TextView imgTitle=view.findViewById(R.id.imgTitle);
        ImageView img=view.findViewById(R.id.img);

        //imgTitle.setText(title);
        circularProgressDrawable=new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(7f);
        circularProgressDrawable.setCenterRadius(50f);
        circularProgressDrawable.setColorSchemeColors(Color.WHITE);
        Picasso.get().load(uri).error(R.drawable.ic_error).placeholder(circularProgressDrawable).into(img);
        img.setOnClickListener(v->{
            Intent intent=new Intent(context,FullImageActivity.class);
            intent.putExtra("title",title);
            intent.putExtra("img",uri);
            intent.putExtra("desc",desc);

            context.startActivity(intent);
        });
    }
}
