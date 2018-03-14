package com.example.vicky.shoppingguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by vicky on 6/10/17.
 */

public class Men extends AppCompatActivity{
    ActionBar actionBar;
    GridView gridView;
    String[] gridViewString ={"Foot wear","Mens Grooming","Top Wear","Bottom Wear","Watches","Sports Wear"};
    int[] gridViewImageId={
            R.drawable.footwear,R.drawable.grooming,R.drawable.topwear,R.drawable.bottomwear,R.drawable.watches,R.drawable.sportswear

    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.men);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Men");
        actionBar.setDisplayHomeAsUpEnabled(true);
        CustomAdaptorGridCategories customAdaptorGridCategories=new CustomAdaptorGridCategories(Men.this,gridViewString,gridViewImageId);
        gridView=(GridView)findViewById(R.id.gridViewMen);
        gridView.setAdapter(customAdaptorGridCategories);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(gridViewString[position]=="Foot wear")
                    startActivity(new Intent(Men.this,FootWear.class));
                if(gridViewString[position]=="Mens Grooming")
                    startActivity(new Intent(Men.this,MenGrooming.class));
                if(gridViewString[position]=="Top Wear")
                    startActivity(new Intent(Men.this,TopWear.class));
                if(gridViewString[position]=="Bottom Wear")
                    startActivity(new Intent(Men.this,BottomWear.class));
                if(gridViewString[position]=="Watches")
                    startActivity(new Intent(Men.this,Watches.class));
                if(gridViewString[position]=="Sports Wear")
                    startActivity(new Intent(Men.this,SportsWear.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {

        Intent i=new Intent(Men.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
