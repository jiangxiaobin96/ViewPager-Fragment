package com.example.asus.newcontest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;


/**
 * Created by ASUS on 2017/11/8.
 */

public class fragment3 extends Fragment {

    private LineChart mLineChart;
    private PieChart mPieChart;
    Button btn_1,btn_2,btn_3;
    TextView zhaiyao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view= inflater.inflate(R.layout.layout3, container, false);

        //对View中控件的操作方法
        mLineChart = (LineChart) view.findViewById(R.id.spread_line_chart);
        zhaiyao = (TextView) view.findViewById(R.id.zhaiyao);
        mPieChart = (PieChart) view.findViewById(R.id.consume_pie_chart);
        btn_1 = (Button) view.findViewById(R.id.btn_1);
        btn_2 = (Button) view.findViewById(R.id.btn_2);
        btn_3 = (Button) view.findViewById(R.id.btn_3);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLineChart.setVisibility(View.VISIBLE);
                zhaiyao.setVisibility(View.GONE);
                mPieChart.setVisibility(View.GONE);
                LineData mLineData = getLineData();
                showChart(mLineChart, mLineData, Color.rgb(114, 188, 223));
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLineChart.setVisibility(View.GONE);
                zhaiyao.setVisibility(View.VISIBLE);
                mPieChart.setVisibility(View.GONE);
                zhaiyao.setText("1.必须坚持中国特色社会主义政治发展道路\n" +
                        "2.要坚持中国特色社会主义文化发展道路\n" +
                        "3.这就是必须从理论和实践结合上系统回答新时代坚持和发展什么样的中国特色社会主义、怎样坚持和发展中国特色社会主义\n" +
                        "4.明确全面深化改革总目标是完善和发展中国特色社会主义制度、推进国家治理体系和治理能力现代化\n" +
                        "5.必须坚持和完善中国特色社会主义制度\n" +
                        "6.明确全面推进依法治国总目标是建设中国特色社会主义法治体系、建设社会主义法治国家\n" +
                        "7.始终坚持和发展中国特色社会主义\n" +
                        "8.明确坚持和发展中国特色社会主义\n" +
                        "9.完善和发展中国特色社会主义军事制度\n" +
                        "10.发展中国特色社会主义文化");
                zhaiyao.setTextSize(17);
                //zhaiyao.setTextColor(0xffffff);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPieChart.setVisibility(View.VISIBLE);
                mLineChart.setVisibility(View.GONE);
                zhaiyao.setVisibility(View.GONE);
                PieData mPieData = getPieData();
                showChart(mPieChart, mPieData);
            }
        });
        return view;
    }

    private void showChart(PieChart pieChart, PieData pieData) {
        pieChart.setHoleColorTransparent(true);

        pieChart.setHoleRadius(60f);  //半径
        pieChart.setTransparentCircleRadius(64f); // 半透明圈
        //pieChart.setHoleRadius(0)  //实心圆
        pieChart.setDrawCenterText(true);  //饼状图中间可以添加文字
        pieChart.setDrawHoleEnabled(true);
        pieChart.setRotationAngle(90); // 初始旋转角度
        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true); // 可以手动旋转

        // display percentage values
        pieChart.setUsePercentValues(true);  //显示成百分比
        pieChart.setCenterText("新词比例");  //饼状图中间的文字
        pieChart.setDescriptionTextSize(1);
        pieData.setValueTextSize(10);
        pieChart.setCenterTextSize(15);
//        pieChart.setCenterTextSizePixels(50);
        //设置数据
        pieChart.setData(pieData);

        // undo all highlights
//      pieChart.highlightValues(null);
//      pieChart.invalidate();

        Legend mLegend = pieChart.getLegend();  //设置比例图
        //mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);  //最右边显示
//      mLegend.setForm(LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);

        pieChart.animateXY(1000, 1000);  //设置动画
        // mChart.spin(2000, 0, 360);
    }


    private PieData getPieData() {

        ArrayList<String> xValues = new ArrayList<String>();  //xVals用来表示每个饼块上的内容

        xValues.add("不忘初心");xValues.add("坚定不移");
        ArrayList<Entry> yValues = new ArrayList<Entry>();  //yVals用来表示封装每个饼块的实际数据

        // 饼图数据
        /**
         * 将一个饼形图分成四部分， 四部分的数值比例为14:14:34:38
         * 所以 14代表的百分比就是14%
         */
        float quarterly1 = 90;
        float quarterly2 = 10;

        yValues.add(new Entry(quarterly1, 0));
        yValues.add(new Entry(quarterly2, 1));

        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, ""/*显示在比例图上*/);
        pieDataSet.setSliceSpace(0f); //设置个饼状图之间的距离

        ArrayList<Integer> colors = new ArrayList<Integer>();

        // 饼图颜色
//        colors.add(Color.rgb(205, 205, 205));
//        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));

        pieDataSet.setColors(colors);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度

        PieData pieData = new PieData(xValues, pieDataSet);

        return pieData;
    }

    // 设置显示的样式
    private void showChart(LineChart lineChart, LineData lineData, int color) {
        lineChart.setDrawBorders(false);  //是否在折线图上添加边框

        // no description text
        lineChart.setDescription("新旧对比");// 数据描述
         //如果没有数据的时候，会显示这个，类似listview的emtpyview
        lineChart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable / disable grid background
        lineChart.setDrawGridBackground(false); // 是否显示表格颜色
        lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度

        // enable touch gestures
        lineChart.setTouchEnabled(true); // 设置是否可以触摸

        // enable scaling and dragging
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放

        // if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(false);//

        lineChart.setBackgroundColor(color);// 设置背景

        // add data
        lineChart.setData(lineData); // 设置数据

        // get the legend (only possible after setting data)
        Legend mLegend = lineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的

        // modify the legend ...
        // mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
        mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式
        mLegend.setFormSize(6f);// 字体
        mLegend.setTextColor(Color.WHITE);// 颜色
//      mLegend.setTypeface(mTf);// 字体

        lineChart.animateX(2500); // 立即执行的动画,x轴
    }


    private LineData getLineData() {
        ArrayList<String> xValues = new ArrayList<String>();
        xValues.add("体系");
        xValues.add("文化");
        xValues.add("社会主义");
        xValues.add("建设");
        xValues.add("推动");
        xValues.add("坚持");
        xValues.add("发展");
        xValues.add("加强");
        xValues.add("全面");
        xValues.add("政治");
        xValues.add("经济");
        xValues.add("社会");
        xValues.add("国家");
        xValues.add("完善");
        xValues.add("中国");
        xValues.add("实现");
        xValues.add("制度");
        xValues.add("必须");
        xValues.add("人民");
        xValues.add("推进");

        // y轴的数据
        ArrayList<Entry> yValues = new ArrayList<Entry>();
        int[] value = {77, 79, 146, 165, 47, 131, 232, 74, 94, 93, 70, 262, 115, 57, 195, 85, 100, 61, 204, 81};
        for (int i = 0; i < 20; i++) {
            yValues.add(new Entry(value[i], i));
        }

        // create a dataset and give it a type
        // y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yValues, "热词" /*显示在比例图上*/);
        // mLineDataSet.setFillAlpha(110);
        // mLineDataSet.setFillColor(Color.RED);

        //用y轴的集合来设置参数
        lineDataSet.setLineWidth(1.75f); // 线宽
        lineDataSet.setCircleSize(3f);// 显示的圆形大小
        lineDataSet.setColor(Color.WHITE);// 显示颜色
        lineDataSet.setCircleColor(Color.WHITE);// 圆形的颜色
        lineDataSet.setHighLightColor(Color.WHITE); // 高亮的线的颜色

        ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
        lineDataSets.add(lineDataSet); // add the datasets

        // create a data object with the datasets
        LineData lineData = new LineData(xValues, lineDataSets);

        return lineData;
    }

}
