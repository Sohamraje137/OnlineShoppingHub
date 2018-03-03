package com.example.vicky.shoppingguide;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.ponnamkarthik.richlinkpreview.RichLinkView;
import io.github.ponnamkarthik.richlinkpreview.RichLinkViewTelegram;
import io.github.ponnamkarthik.richlinkpreview.ViewListener;

/**
 * Created by vicky on 2/3/18.
 */

public class URLAdapter extends BaseAdapter {
    //RichLinkView richLinkView;
    Context context;
    ArrayList<URL> urls;
    String currURL="";

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

    public static class ViewHolder{
        RichLinkView richLinkView;
        Button buttonGo,buttonDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      view=null;
        final ViewHolder viewHolder;
       if(view==null) {
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(context);
            view = inflater.inflate(R.layout.list_items2, viewGroup, false);
           // view.setClickable(true);
           // view.setOnClickListener(mylistener);
            viewHolder.richLinkView = (RichLinkView) view.findViewById(R.id.richLinkView);
            viewHolder.buttonGo= (Button) view.findViewById(R.id.gotoLink);
            viewHolder.buttonDelete= (Button) view.findViewById(R.id.deleteLink) ;
           view.setTag(viewHolder);
        }
        else
            viewHolder= (ViewHolder) view.getTag();
        final URL url=urls.get(i);
        viewHolder.richLinkView.setLink(url.getUrl(), new ViewListener() {

            @Override
            public void onSuccess(boolean status) {

            }

            @Override
            public void onError(Exception e) {
                Log.i("From inside","Errpr:"+e);
            }
        });
        viewHolder.buttonDelete.setVisibility(View.VISIBLE);
        viewHolder.buttonGo.setVisibility(View.VISIBLE);
        viewHolder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb= new AlertDialog.Builder(context);
                adb.setTitle("Choose");
                adb.setItems(new String[]{"Delete"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyDatabase database=new MyDatabase(context);
                        database.delete(url.getUrl());
                       // Toast.makeText(context,"Successful",Toast.LENGTH_LONG).show();
                    }
                });
                adb.show();
            }
        });

        return view;
    }
}
