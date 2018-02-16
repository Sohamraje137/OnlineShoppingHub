package com.example.vicky.shoppingguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by vicky on 6/10/17.
 */

public class CustomAdaptorGridCategories extends BaseAdapter {
    private Context context;
    String[] gridViewString;
    int[] gridViewImageID;

    public CustomAdaptorGridCategories(Context context,String[] gridViewString,int[] gridViewImageID){
        this.context=context;
        this.gridViewImageID=gridViewImageID;
        this.gridViewString=gridViewString;
    }
    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int position) {
        return gridViewString[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        gridViewAndroid=inflater.inflate(R.layout.listview_categories,null);
        ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.categoryImage);
        TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.categoryText);
        textViewAndroid.setText(gridViewString[position]);
        imageViewAndroid.setImageResource(gridViewImageID[position]);
        return gridViewAndroid;

    }
}
