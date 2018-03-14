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

public class Appliances extends AppCompatActivity{
    ActionBar actionBar;
    GridView gridView;
    String[] gridViewString ={"TV","Washing Machine","Refrigerator","AC","Geysers","Kitchen Appliances"};
    int[] gridViewImageId={
            R.drawable.tv,R.drawable.washing_machi,R.drawable.refri,R.drawable.air_cond,R.drawable.geyser,R.drawable.kitchen};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appliances);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Appliances");
        actionBar.setDisplayHomeAsUpEnabled(true);
        CustomAdaptorGridCategories customAdaptorGridCategories=new CustomAdaptorGridCategories(Appliances.this,gridViewString,gridViewImageId);
        gridView=(GridView)findViewById(R.id.gridViewAppliances);
        gridView.setAdapter(customAdaptorGridCategories);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(gridViewString[position]=="TV")
                    startActivity(new Intent(Appliances.this,TV.class));
                if(gridViewString[position]=="Washing Machine")
                    startActivity(new Intent(Appliances.this,WashingMachine.class));
                if(gridViewString[position]=="Refrigerator")
                    startActivity(new Intent(Appliances.this,Refrigerator.class));
                if(gridViewString[position]=="AC")
                    startActivity(new Intent(Appliances.this,AC.class));
                if(gridViewString[position]=="Geysers")
                    startActivity(new Intent(Appliances.this,Geyser.class));
                if(gridViewString[position]=="Kitchen Appliances")
                    startActivity(new Intent(Appliances.this,KitchenAppliances.class));
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

        Intent i=new Intent(Appliances.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
