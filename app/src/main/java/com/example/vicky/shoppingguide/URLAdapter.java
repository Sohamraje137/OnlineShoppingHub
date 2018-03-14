package com.example.vicky.shoppingguide;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.ponnamkarthik.richlinkpreview.MetaData;
import io.github.ponnamkarthik.richlinkpreview.RichLinkListener;
import io.github.ponnamkarthik.richlinkpreview.RichLinkView;
import io.github.ponnamkarthik.richlinkpreview.RichLinkViewTelegram;
import io.github.ponnamkarthik.richlinkpreview.ViewListener;

/**
 * Created by vicky on 2/3/18.
 */

public class URLAdapter extends BaseAdapter {
    //RichLinkView richLinkView;
    Context context;
    ArrayList<URL> urls=null;
    String currURL="";

    ArrayList<MetaData> metaData= new ArrayList<>();
    public URLAdapter(Context context, ArrayList<URL> urls){
        this.context=context;
        this.urls=urls;
        if(urls!=null) {
            for (int i = 0; i < urls.size(); i++) {
                metaData.add(null);
            }
        }
    }

    @Override
    public int getCount() {
        return (urls==null)?0:urls.size();
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);
    }

    @Override
    public int getViewTypeCount() {
        return (getCount()==0)?1:getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;
       if(view==null) {
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(context);
            view = inflater.inflate(R.layout.list_items2, viewGroup, false);

            viewHolder.richLinkView = (RichLinkView) view.findViewById(R.id.richLinkView);
            viewHolder.buttonGo= (Button) view.findViewById(R.id.gotoLink);
            viewHolder.buttonDelete= (Button) view.findViewById(R.id.deleteLink) ;
           view.setTag(viewHolder);
        }
        else
            viewHolder= (ViewHolder) view.getTag();
       if(urls.get(i)!=null) {
           final URL url = urls.get(i);
           if(metaData.get(i) != null) {
              viewHolder.richLinkView.setLinkFromMeta(metaData.get(i));
           }else {
               viewHolder.richLinkView.setLink(url.getUrl(), new ViewListener() {

                   @Override
                   public void onSuccess(boolean status) {
                       try {
                           metaData.set(i, viewHolder.richLinkView.getMetaData());
                       } catch (IndexOutOfBoundsException e) {
                           e.printStackTrace();
                       }
                   }

                   @Override
                   public void onError(Exception e) {
                       Log.i("From inside", "Errpr:" + e);
                   }
               });
           }
           viewHolder.richLinkView.setDefaultClickListener(false);
           viewHolder.richLinkView.setClickListener(new RichLinkListener() {
               @Override
               public void onClicked(View view, MetaData meta) {
                   //do stuff
                   Toast.makeText(context, meta.getTitle(), Toast.LENGTH_SHORT).show();
               }
           });
           viewHolder.buttonDelete.setVisibility(View.VISIBLE);
           viewHolder.buttonGo.setVisibility(View.VISIBLE);
           viewHolder.buttonDelete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   AlertDialog.Builder adb = new AlertDialog.Builder(context);
                   adb.setTitle("Choose");
                   adb.setItems(new String[]{"Delete"}, new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           MyDatabase database = new MyDatabase(context);
                           database.delete(url.getUrl());

                           urls.remove(i);
                           metaData.remove(i);
                           URLAdapter.this.notifyDataSetChanged();
                           // Toast.makeText(context,"Successful",Toast.LENGTH_LONG).show();
                       }
                   });
                   adb.show();
               }
           });
           viewHolder.buttonGo.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   //to open browser here
                   Intent i = new Intent(context.getApplicationContext(), SingleWebView.class);
                   i.putExtra("link", url.getUrl());
                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                   context.getApplicationContext().startActivity(i);
               }
           });
       }
        return view;
    }


}
