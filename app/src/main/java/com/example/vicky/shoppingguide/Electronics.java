package com.example.vicky.shoppingguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by vicky on 6/10/17.
 */

public class Electronics extends AppCompatActivity {
    GridView gridView;
    String[] gridViewString ={"Mobiles","Mobile Accesories","Smart Wearables","Laptops","Computer Accesories","Cameras"
    };
    int[] gridViewImageId={
            R.drawable.mobiles,R.drawable.mobile_accesories,R.drawable.smartwearable,R.drawable.laptops,R.drawable.computer_accesories,
            R.drawable.cameras
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electronics);
        CustomAdaptorGridCategories customAdaptorGridCategories=new CustomAdaptorGridCategories(this,gridViewString,gridViewImageId);
        gridView=(GridView)findViewById(R.id.gridViewElectronics);
        gridView.setAdapter(customAdaptorGridCategories);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(gridViewString[position]=="Mobiles")
                    startActivity(new Intent(Electronics.this,Mobiles.class));
                if(gridViewString[position]=="Mobile Accesories")
                    startActivity(new Intent(Electronics.this,MobileAccesories.class));
                if(gridViewString[position]=="Smart Wearables")
                    startActivity(new Intent(Electronics.this,SmartWearables.class));
                if(gridViewString[position]=="Laptops")
                    startActivity(new Intent(Electronics.this,Laptops.class));
                if(gridViewString[position]=="Computer Accesories")
                    startActivity(new Intent(Electronics.this,ComputerAccesories.class));
                if(gridViewString[position]=="Cameras")
                    startActivity(new Intent(Electronics.this,Cameras.class));
            }
        });
    }
}
