package com.example.vicky.shoppingguide;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vicky on 3/3/18.
 */

public class WishList extends Fragment {
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_wishlist,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView= (ListView) view.findViewById(R.id.listShowWishlist);
        //MyDatabase database=new MyDatabase(getContext());
        //ArrayList<URL> urls=database.getAllurls();
       // setListView(urls);



        DataTask dataTask=new DataTask();
         dataTask.execute();

    }

    private void setListView(ArrayList<URL> urls) {
        URLAdapter adapter=new URLAdapter(getContext(),urls);
        listView.setAdapter(adapter);
    }
   class  DataTask extends AsyncTask<Integer,Void,ArrayList<URL>>{
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog=new ProgressDialog(getContext());
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
        }

        @Override
        protected ArrayList<URL> doInBackground(Integer... integers) {
            MyDatabase database=new MyDatabase(getContext());
            ArrayList<URL> urls=database.getAllurls();
            return urls;
        }

        @Override
        protected void onPostExecute(ArrayList<URL> urls) {

            setListView(urls);
            progressDialog.dismiss();
           /*Log.i("XXXXXXXXXXX","XXXXXXXXXXXXX");
            listView.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
               public boolean onLongClick(View v) {
                   Toast.makeText(getContext(),"Long Clicked",Toast.LENGTH_LONG).show();
                   return true;
               }
           });*/
        }
    }


}
