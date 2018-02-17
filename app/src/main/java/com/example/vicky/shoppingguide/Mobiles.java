package com.example.vicky.shoppingguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by vicky on 6/10/17.
 */

public class Mobiles extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String flipkart = "https://www.flipkart.com/search?as=off&as-show=on&count=40&otracker=start";
    String amazon="https://www.amazon.in/s/ref=";

    String output = "";
    String outputa="";
    String outputs="";
    String brand = "", ram = "", internal = "", battery = "", screen = "", sort = "";
    ActionBar actionBar;
    Spinner dropdownBrand, dropdownRam, dropdownInternalStorage, dropdownBattery, dropdownScreen, dropdownsort;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobiles);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Mobile Specification");
        actionBar.setDisplayHomeAsUpEnabled(true);
        //adapter for brand only
        dropdownBrand = (Spinner) findViewById(R.id.brandName);
        String[] itemsBrand = {"I don't go by brand", "Samsung", "Apple", "Huawei", "Oppo", "Vivo", "LG", "Xiaomi", "Lenovo", "ZTE"};
        ArrayAdapter<String> arrayAdapterBrand = new ArrayAdapter<String>(Mobiles.this, R.layout.spinner_row, itemsBrand);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownBrand.setAdapter(arrayAdapterBrand);
        dropdownBrand.setOnItemSelectedListener(this);
        //adapter for ram
        dropdownRam = (Spinner) findViewById(R.id.ramMobile);
        String[] itemsRam = {"512MB", "1 GB", "2 GB", "3 GB", "4 GB", "6 GB and above"};
        ArrayAdapter<String> arrayAdapterRam = new ArrayAdapter<String>(Mobiles.this, R.layout.spinner_row, itemsRam);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownRam.setAdapter(arrayAdapterRam);
        dropdownRam.setOnItemSelectedListener(this);
        //adapter for internal storage
        dropdownInternalStorage = (Spinner) findViewById(R.id.internalMobile);
        String[] itemsInternal = {"4GB", "8GB", "16GB", "32GB", "64GB", "128BG", "256GB"};
        ArrayAdapter<String> arrayAdapterinternal = new ArrayAdapter<String>(Mobiles.this, R.layout.spinner_row, itemsInternal);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownInternalStorage.setAdapter(arrayAdapterinternal);
        dropdownInternalStorage.setOnItemSelectedListener(this);
        //adapter for battery
        dropdownBattery = (Spinner) findViewById(R.id.batterySize);
        String[] itemsBattery = {"3000maH", "4000mah", "5000mah", "6000mah"};
        ArrayAdapter<String> arrayAdapterbattery = new ArrayAdapter<String>(Mobiles.this, R.layout.spinner_row, itemsBattery);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownBattery.setAdapter(arrayAdapterbattery);
        dropdownBattery.setOnItemSelectedListener(this);

        dropdownScreen = (Spinner) findViewById(R.id.screenSize);
        String[] itemsScreen = {"3 inch", "4 inch", "4.5 inch", "5 inch", "5.5-5.9 inch", "6 inch"};
        ArrayAdapter<String> arrayAdapterscreen = new ArrayAdapter<String>(Mobiles.this, R.layout.spinner_row, itemsScreen);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownScreen.setAdapter(arrayAdapterscreen);
        dropdownScreen.setOnItemSelectedListener(this);

        dropdownsort = (Spinner) findViewById(R.id.sortbyMobile);
        String[] itemsSort = {"Relevance", "Popularity", "Price-High to low", "Price-Low to high", "Newest first"};
        ArrayAdapter<String> arrayAdaptersort = new ArrayAdapter<String>(Mobiles.this, R.layout.spinner_row, itemsSort);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownsort.setAdapter(arrayAdaptersort);
        dropdownsort.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            case R.id.brandName:
                brand = (String) parent.getItemAtPosition(position);
                //Toast.makeText(parent.getContext(),"selected brand:"+brand,Toast.LENGTH_LONG).show();
                break;
            case R.id.ramMobile:
                ram = (String) parent.getItemAtPosition(position);

                break;
            case R.id.internalMobile:
                internal = (String) parent.getItemAtPosition(position);
                break;
            case R.id.batterySize:
                battery = (String) parent.getItemAtPosition(position);
                break;
            case R.id.screenSize:
                screen = (String) parent.getItemAtPosition(position);
                break;
            case R.id.sortbyMobile:
                sort = (String) parent.getItemAtPosition(position);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void searchMobiles(View view) {
        if (brand.equals("I don't go by brand")) {
            output = "mobiles " + ram + " ram " + internal + " internal " + screen + " screen";
            //Toast.makeText(Mobiles.this, output, Toast.LENGTH_LONG).show();
        } else {
            output = brand + " mobile " + ram + " ram " + internal + " internal " + screen + " screen ";
            //Toast.makeText(Mobiles.this, output, Toast.LENGTH_LONG).show();
        }
        if (sort.equals("Relevance")) {
            flipkart += "&q=" + output;
            amazon+="sr_st_relevanceblender";
            amazon+="?keywords="+output;
            amazon+="&sort=relevanceblender";
        }
        else if (sort.equals("Popularity")) {
            flipkart += "&p%5B%5D=sort%3Dpopularity" + "&q=" + output;
            amazon+="ref=sr_st_review-rank";
            amazon+="?keywords="+output;
            amazon+="&sort=review-rank";
        }
        else if (sort.equals("Price-High to low")) {
            flipkart += "&p%5B%5D=sort%3Dprice_desc" + "&q=" + output;
            amazon+="ref=sr_st_price-desc-rank";
            amazon+="?keywords="+output;
            amazon+="&sort=price-desc-rank";
        }
        else if (sort.equals("Price-Low to high")) {
            flipkart += "&p%5B%5D=sort%3Dprice_asc" + "&q=" + output;
            amazon+="ref=sr_st_price-asc-rank";
            amazon+="?keywords="+output;
            amazon+="&sort=price-asc-rank";
        }
        else if (sort.equals("Newest first")) {
            flipkart += "&p%5B%5D=sort%3Drecency_desc" + "&q=" + output;
            amazon+="ref=sr_st_date-desc-rank";
            amazon+="?keywords="+output;
            amazon+="&sort=date-desc-rank";
        }
        Intent i=new Intent(this,ShoppingActivity.class);
        i.putExtra("flipkart",flipkart);
        i.putExtra("amazon",amazon);
        flipkart="https://www.flipkart.com/search?as=off&as-show=on&count=40&otracker=start";
        amazon="https://www.amazon.in/s/ref=";
        startActivity(i);

    }

}
