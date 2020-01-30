package com.example.oblig1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] name;
    private final Bitmap[] imageId;

    public CustomList(Activity context, String[] name, Bitmap[] imageId) {
        super(context, R.layout.list_single, name);
        this.context = context;
        this.name = name;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        txtTitle.setText(name[position]);
        imageView.setImageBitmap(imageId[position]);
        return rowView;
    }
    public String[] getNames(){
    return name;}
    public Bitmap[] getIds(){
        return imageId;
    }
}