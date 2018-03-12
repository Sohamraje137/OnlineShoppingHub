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

public class Women extends AppCompatActivity{
    ActionBar actionBar;
    GridView gridView;
    String[] gridViewString ={"Western Wear","Lingerie","Swim and beachwear","Ethnic Wear","Jewellery","Grooming"};
    int[] gridViewImageId={
            R.drawable.western,R.drawable.lingerie,R.drawable.swimsuit,R.drawable.ethnic,R.drawable.jewel,R.drawable.grooming_wom};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Women");
        actionBar.setDisplayHomeAsUpEnabled(true);
        CustomAdaptorGridCategories customAdaptorGridCategories=new CustomAdaptorGridCategories(Women.this,gridViewString,gridViewImageId);
        gridView=(GridView)findViewById(R.id.gridViewWomen);
        gridView.setAdapter(customAdaptorGridCategories);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(gridViewString[position]=="Western Wear")
                    startActivity(new Intent(Women.this,WesternWear.class));
                if(gridViewString[position]=="Lingerie")
                    startActivity(new Intent(Women.this,Lingerie.class));
                if(gridViewString[position]=="Swim and beachwear")
                    startActivity(new Intent(Women.this,SwimBeach.class));
                if(gridViewString[position]=="Ethnic Wear")
                    startActivity(new Intent(Women.this,Ethnic.class));
                if(gridViewString[position]=="Jewellery")
                    startActivity(new Intent(Women.this,Jewellery.class));
                if(gridViewString[position]=="Grooming")
                    startActivity(new Intent(Women.this,GroomingWom.class));
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

        Intent i=new Intent(Women.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
