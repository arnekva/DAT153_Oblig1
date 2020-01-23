package com.example.oblig1;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GlobalStorage extends Application {

    private ArrayList<Image> images = new ArrayList<Image>();

    public ArrayList<Image> getImages(){
        return images;
    }
    public void addImage(Image image){
        images.add(image);
    }
    public boolean removeImage(Image image){
        return this.images.remove(image);
    }
}
