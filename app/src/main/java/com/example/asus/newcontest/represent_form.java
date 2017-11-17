package com.example.asus.newcontest;

/**
 * Created by ASUS on 2017/11/15.
 */

public class represent_form {
    private int imageId;
    private String name;
    public represent_form(String name,int imageId){
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
