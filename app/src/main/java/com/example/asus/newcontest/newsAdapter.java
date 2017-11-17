package com.example.asus.newcontest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2017/11/14.
 */

public class newsAdapter extends ArrayAdapter<news_link> {
    private int resourceId;
    public newsAdapter(Context context, int textViewResourceId, List<news_link> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        news_link link = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView newsImage = (ImageView) view.findViewById(R.id.news_image);
        TextView newsName = (TextView) view.findViewById(R.id.news_name);
        newsImage.setImageResource(link.getImageId());
        newsName.setText(link.getName());
        return view;
    }
}
