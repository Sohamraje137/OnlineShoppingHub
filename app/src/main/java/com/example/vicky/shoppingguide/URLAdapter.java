package com.example.vicky.shoppingguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.ponnamkarthik.richlinkpreview.RichLinkView;
import io.github.ponnamkarthik.richlinkpreview.ViewListener;

/**
 * Created by vicky on 2/3/18.
 */

public class URLAdapter extends BaseAdapter {
    RichLinkView richLinkView;
    Context context;
    ArrayList<URL> urls;

    public URLAdapter(Context context, ArrayList<URL> urls){
        this.context=context;
        this.urls=urls;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view1=inflater.inflate(R.layout.list_items2,viewGroup,false);

        richLinkView= (RichLinkView) view1.findViewById(R.id.richLinkView);

        URL url=urls.get(i);
        richLinkView.setLink(url.getUrl(), new ViewListener() {

            @Override
            public void onSuccess(boolean status) {

            }

            @Override
            public void onError(Exception e) {

            }
        });


        return view1;
    }
}
