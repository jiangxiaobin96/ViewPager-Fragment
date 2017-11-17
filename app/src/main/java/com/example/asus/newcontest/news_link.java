package com.example.asus.newcontest;

/**
 * Created by ASUS on 2017/11/14.
 */

public class news_link  {
    private int imageId;
    private String name;
    public news_link(String name,int imageId){
        this.imageId = imageId;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
