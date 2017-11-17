package com.example.asus.newcontest;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.newcontest.View.ImageBarnnerViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/11/8.
 */

public class fragment1 extends android.support.v4.app.Fragment implements ImageBarnnerViewGroup.ImageBarnenrLister{

    private ImageBarnnerViewGroup mGroup;

    private List<news_link> linkList = new ArrayList<>();

    private int[] ids = new int[]{
            R.drawable.news_1,
            R.drawable.news_2,
            R.drawable.news_3,
            R.drawable.news_1,
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view= inflater.inflate(R.layout.layout1, container, false);

        //对View中控件的操作方法
        mGroup = (ImageBarnnerViewGroup) view.findViewById(R.id.imageGroup);
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        for (int i = 0; i < ids.length; i++) {
            ImageView iv = new ImageView(this.getContext());
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setLayoutParams(new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT));
            iv.setImageResource(ids[i]);
            mGroup.addView(iv);

        }
        mGroup.setLister(this);

        //新闻链接
        init();
        newsAdapter adapter = new newsAdapter(this.getContext(),R.layout.linkings,linkList);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
        return view;
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
    @Override
    public void clickImageIndex(int pos) {
        Toast.makeText(this.getContext(),"pos=" + pos, Toast.LENGTH_SHORT).show();
    }

    private void init(){
        news_link link1 = new news_link("认真学习领会十九大精神 凝心聚力做好全面媒体报道",R.drawable.link1);
        linkList.add(link1);

        news_link link2 = new news_link("十九大上的外媒面孔",R.drawable.link2);
        linkList.add(link2);

        news_link link3 = new news_link("十九大新闻发言人举行发布会",R.drawable.link3);
        linkList.add(link3);

        news_link link4 = new news_link("习近平重要讲话",R.drawable.link4);
        linkList.add(link4);
    }
}
