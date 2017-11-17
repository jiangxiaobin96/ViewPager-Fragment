package com.example.asus.newcontest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ASUS on 2017/11/14.
 */

public class fragment4 extends Fragment{

    private Button xin;
    private Button b_1,b_2,b_3,b_4,b_5;
    private TextView t_1,t_2,t_3,t_4,t_5;
    private ImageView imageView;
    private LinearLayout linearLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view= inflater.inflate(R.layout.layout4, container, false);

        //对View中控件的操作方法
        xin = (Button) view.findViewById(R.id.xin);
        imageView = (ImageView) view.findViewById(R.id.line);
        linearLayout = (LinearLayout) view.findViewById(R.id.layout);
        b_1 = (Button) view.findViewById(R.id.b_1);
        b_2 = (Button) view.findViewById(R.id.b_2);
        b_3 = (Button) view.findViewById(R.id.b_3);
        b_4 = (Button) view.findViewById(R.id.b_4);
        b_5 = (Button) view.findViewById(R.id.b_5);

        t_1 = (TextView) view.findViewById(R.id.t_1);
        t_2 = (TextView) view.findViewById(R.id.t_2);
        t_3 = (TextView) view.findViewById(R.id.t_3);
        t_4 = (TextView) view.findViewById(R.id.t_4);
        t_5 = (TextView) view.findViewById(R.id.t_5);
        xin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_1.setVisibility(View.VISIBLE);
                t_2.setVisibility(View.GONE);
                t_3.setVisibility(View.GONE);
                t_4.setVisibility(View.GONE);
                t_5.setVisibility(View.GONE);
            }
        });
        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_1.setVisibility(View.GONE);
                t_2.setVisibility(View.VISIBLE);
                t_3.setVisibility(View.GONE);
                t_4.setVisibility(View.GONE);
                t_5.setVisibility(View.GONE);
            }
        });
        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_1.setVisibility(View.GONE);
                t_2.setVisibility(View.GONE);
                t_3.setVisibility(View.VISIBLE);
                t_4.setVisibility(View.GONE);
                t_5.setVisibility(View.GONE);
            }
        });
        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_1.setVisibility(View.GONE);
                t_2.setVisibility(View.GONE);
                t_3.setVisibility(View.GONE);
                t_4.setVisibility(View.VISIBLE);
                t_5.setVisibility(View.GONE);
            }
        });
        b_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_1.setVisibility(View.GONE);
                t_2.setVisibility(View.GONE);
                t_3.setVisibility(View.GONE);
                t_4.setVisibility(View.GONE);
                t_5.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
}
