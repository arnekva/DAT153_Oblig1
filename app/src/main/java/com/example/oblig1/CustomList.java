package com.example.oblig1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Image> {
    private final Activity context;


    public CustomList(Activity context) {
    super(context, R.layout.list_single);
        this.context = context;
        this.addAll(((GlobalStorage) context.getApplication()).getImages());
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        txtTitle.setText(this.getItem(position).getName());
        imageView.setImageBitmap(this.getItem(position).getBitmap());
        return rowView;
    }
}