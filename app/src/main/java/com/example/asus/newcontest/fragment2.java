package com.example.asus.newcontest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/11/8.
 */

public class fragment2 extends Fragment {

    private Button first,second,third,forth,fifth;
    private TextView txt_first,txt_second,txt_third,txt_forth,txt_fifth;
    private List<represent_form> formList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        final View view= inflater.inflate(R.layout.layout2, container, false);

        //对View中控件的操作方法
        first = (Button) view.findViewById(R.id.first);
        second = (Button) view.findViewById(R.id.second);
        third = (Button) view.findViewById(R.id.third);
        forth = (Button) view.findViewById(R.id.forth);
        fifth = (Button) view.findViewById(R.id.fifth);
        txt_first = (TextView) view.findViewById(R.id.txt_first);
        txt_second = (TextView) view.findViewById(R.id.txt_second);
        txt_third = (TextView) view.findViewById(R.id.txt_third);
        txt_forth = (TextView) view.findViewById(R.id.txt_fouth);
        txt_fifth = (TextView) view.findViewById(R.id.txt_fifth);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_first.setVisibility(View.VISIBLE);
                txt_second.setVisibility(View.GONE);
                txt_third.setVisibility(View.GONE);
                txt_forth.setVisibility(View.GONE);
                txt_fifth.setVisibility(View.GONE);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_first.setVisibility(View.GONE);
                txt_second.setVisibility(View.VISIBLE);
                txt_third.setVisibility(View.GONE);
                txt_forth.setVisibility(View.GONE);
                txt_fifth.setVisibility(View.GONE);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_first.setVisibility(View.GONE);
                txt_second.setVisibility(View.GONE);
                txt_third.setVisibility(View.VISIBLE);
                txt_forth.setVisibility(View.GONE);
                txt_fifth.setVisibility(View.GONE);
            }
        });
        forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_first.setVisibility(View.GONE);
                txt_second.setVisibility(View.GONE);
                txt_third.setVisibility(View.GONE);
                txt_forth.setVisibility(View.VISIBLE);
                txt_fifth.setVisibility(View.GONE);
            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_first.setVisibility(View.GONE);
                txt_second.setVisibility(View.GONE);
                txt_third.setVisibility(View.GONE);
                txt_forth.setVisibility(View.GONE);
                txt_fifth.setVisibility(View.VISIBLE);
            }
        });

        //代表构成
        init();
        representAdapter adapter = new representAdapter(this.getContext(),R.layout.represent_form,formList);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
      return view;
    }

    private void init(){
        represent_form form1 = new represent_form("十九大代表名额2287名比十八大增加17名",R.drawable.represent1);
        formList.add(form1);

        represent_form form2 = new represent_form("严把人选政治关和廉洁关，进一步优化代表结构，强调把纪律和规矩挺在前面充分发扬党内民主",R.drawable.represent2);
        formList.add(form2);

        represent_form form3 = new represent_form("生产工作第一线代表占比例不少于三分之一，党内干部所占比例不超过三分之二",R.drawable.represent3);
        formList.add(form3);

        represent_form form4 = new represent_form("注重推荐工人、农民和专业技术人员党员中的先进模范人物",R.drawable.represent4);
        formList.add(form4);

        represent_form form5 = new represent_form("代表中女党员和少数名族党员应占一定比例",R.drawable.represent1);
        formList.add(form5);
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
}
