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
 * Created by ASUS on 2017/11/15.
 */

public class representAdapter extends ArrayAdapter<represent_form> {
    private int resourceId;
    public representAdapter(Context context, int textViewResourceId, List<represent_form> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        represent_form form = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView represent_title = (ImageView) view.findViewById(R.id.represent_image);
        TextView represent_name = (TextView) view.findViewById(R.id.represent_name);
        represent_title.setImageResource(form.getImageId());
        represent_name.setText(form.getName());
        return view;
    }
}
