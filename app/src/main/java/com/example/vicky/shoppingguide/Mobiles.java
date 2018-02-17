package com.example.vicky.shoppingguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by vicky on 6/10/17.
 */

public class Mobiles extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActionBar actionBar;
    Spinner dropdownBrand,dropdownRam,dropdownInternalStorage,dropdownBattery,dropdownScreen,dropdownsort;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobiles);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Mobile Specification");
        actionBar.setDisplayHomeAsUpEnabled(true);
        //adapter for brand only
        dropdownBrand= (Spinner) findViewById(R.id.brandName);
        String[] itemsBrand={"I don't go by brand","Samsung","Apple","Huawei","Oppo","Vivo","LG","Xiaomi","Lenovo","ZTE"};
        ArrayAdapter<String> arrayAdapterBrand=new ArrayAdapter<String>(Mobiles.this,R.layout.spinner_row,itemsBrand);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownBrand.setAdapter(arrayAdapterBrand);

        //adapter for ram
        dropdownRam= (Spinner) findViewById(R.id.ramMobile);
        String[] itemsRam={"512MB","1 GB","2 GB","3 GB","4 GB","6 GB and above"};
        ArrayAdapter<String> arrayAdapterRam=new ArrayAdapter<String>(Mobiles.this,R.layout.spinner_row,itemsRam);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownRam.setAdapter(arrayAdapterRam);

        //adapter for internal storage
        dropdownInternalStorage= (Spinner) findViewById(R.id.internalMobile);
        String[] itemsInternal={"upto 2GB","upto 4GB","upto 8GB","upto 16GB","upto 32GB","upto 64GB","upto 128BG","upto 256GB"};
        ArrayAdapter<String> arrayAdapterinternal=new ArrayAdapter<String>(Mobiles.this,R.layout.spinner_row,itemsInternal);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownInternalStorage.setAdapter(arrayAdapterinternal);

        //adapter for battery
        dropdownBattery= (Spinner) findViewById(R.id.batterySize);
        String[] itemsBattery={"upto 3000maH","upto 4000mah","upto 5000mah","5000mah and above"};
        ArrayAdapter<String> arrayAdapterbattery=new ArrayAdapter<String>(Mobiles.this,R.layout.spinner_row,itemsBattery);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownBattery.setAdapter(arrayAdapterbattery);

        dropdownScreen= (Spinner) findViewById(R.id.screenSize);
        String[] itemsScreen={"less than 3 inch","upto 4 inch","upto 4.5 inch","upto 5.5 inch","5.5-5.6 inch","upto 6 inch"};
        ArrayAdapter<String> arrayAdapterscreen=new ArrayAdapter<String>(Mobiles.this,R.layout.spinner_row,itemsScreen);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownScreen.setAdapter(arrayAdapterscreen);

        dropdownsort= (Spinner) findViewById(R.id.sortbyMobile);
        String[] itemsSort={"Relevance","Popularity","Price-High to low","Price-Low to high","Newest first"};
        ArrayAdapter<String> arrayAdaptersort=new ArrayAdapter<String>(Mobiles.this,R.layout.spinner_row,itemsSort);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownsort.setAdapter(arrayAdaptersort);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
