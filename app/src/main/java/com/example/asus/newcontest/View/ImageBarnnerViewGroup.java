package com.example.asus.newcontest.View;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ASUS on 2017/11/14.
 */

public class ImageBarnnerViewGroup extends ViewGroup {

    private int ChildrenCount;
    private int Childwidth;
    private int Childheight;

    private int x;
    private int index;

    private Scroller scroller;

    //单击事件 单击变量开关

    private boolean isClick;

    private ImageBarnenrLister lister;

    public void setLister(ImageBarnenrLister lister) {
        this.lister = lister;
    }

    public ImageBarnenrLister getLister() {
        return lister;
    }

    public interface ImageBarnenrLister{
        void clickImageIndex(int pos);//图片索引值
    }

    //自动轮播 TimerTask,Handler,Timer
    private boolean isAuto = true;
    private Timer timer = new Timer();
    private TimerTask timerTask;
    private Handler autoHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    if (++index >= ChildrenCount){
                        index = 0;//最后一张图片到第一张图片
                    }
                    scrollTo(Childwidth * index, 0);
                    break;
            }
        }
    };

    private void startAuto(){
        isAuto = true;
    }

    private void stopAuto(){
        isAuto = false;
    }

    public ImageBarnnerViewGroup(Context context) {
        super(context);
        initobj();
    }

    public ImageBarnnerViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initobj();
    }

    public ImageBarnnerViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initobj();
    }

    private void initobj(){
        scroller = new Scroller(getContext());

        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (isAuto){
                    autoHandler.sendEmptyMessage(0);
                }
            }
        };
        timer.schedule(timerTask,100,1000);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),0);
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        ChildrenCount = getChildCount();
        if (ChildrenCount == 0){
            setMeasuredDimension(0,0);
        }else {
            measureChildren(widthMeasureSpec,heightMeasureSpec);
            View view = getChildAt(0);
            Childwidth = view.getMeasuredWidth();
            Childheight = view.getMeasuredHeight();

            int width = view.getMeasuredWidth() * ChildrenCount;
            setMeasuredDimension(width,Childheight);
        }
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://按下一瞬间
                stopAuto();
                if (!scroller.isFinished()){
                    scroller.abortAnimation();
                }
                isClick = true;
                x = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE://按下之后在屏幕上移动过程
                int moveX = (int) event.getX();
                int distance = moveX - x;
                scrollBy(-distance,0);
                x = moveX;
                isClick = false;
                break;
            case MotionEvent.ACTION_UP://抬起一瞬间
                if (index < 0){
                    index = 0;
                }else if (index > ChildrenCount - 1) {
                    index = ChildrenCount - 1;
                }
                if (isClick){
                    lister.clickImageIndex(index);
                }else {
                    int scrollX = getScrollX();
                    index = (scrollX + Childwidth / 2) / Childwidth;
                    int dx = index * Childwidth - scrollX;
                    scroller.startScroll(scrollX,0,dx,0);
                    postInvalidate();
                }


                //scrollTo(index * Childwidth, 0);
                startAuto();
                break;
            default:break;
        }
        return true;//ViewGroup容器的父View已经处理好了该事件
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(changed){
            int leftMargin = 0;
            for (int i = 0; i < ChildrenCount; i ++){
                View view = getChildAt(i);
                view.layout(leftMargin, 0, leftMargin + Childwidth, Childheight);
                leftMargin += Childwidth;
            }
        }
    }
}
