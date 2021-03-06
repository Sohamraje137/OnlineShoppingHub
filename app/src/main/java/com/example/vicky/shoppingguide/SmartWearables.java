package com.example.vicky.shoppingguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by vicky on 6/10/17.
 */

public class SmartWearables extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String flipkart = "https://www.flipkart.com/search?as=off&as-show=on&count=40&otracker=start";
    String amazon="https://www.amazon.in/s/ref=";
    String snapdeal="https://www.snapdeal.com/search?keyword=";
    String output = "";
    int flag=0;
    String brand = "", formorw = "", displaytype = "", sort = "";
    Spinner dropdownMethod,dropdownBrand, dropdownFor, dropdownDisplayType, dropdownsort;
    ActionBar actionBar;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_wearables);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Smart Wearables");
        actionBar.setDisplayHomeAsUpEnabled(true);
        editText= (EditText) findViewById(R.id.productKeywordWatch);

        dropdownMethod = (Spinner) findViewById(R.id.searchMethodWatch);
        String[] itemsMethod = {"Search by Keyword","Search by specification"};

        ArrayAdapter<String> arrayAdapterMethod = new ArrayAdapter<String>(SmartWearables.this, R.layout.spinner_row, itemsMethod);
        arrayAdapterMethod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownMethod.setAdapter(arrayAdapterMethod);
        dropdownMethod.setOnItemSelectedListener(this);

        //adapter for brand only
        dropdownBrand = (Spinner) findViewById(R.id.brandNameWatch);
        String[] itemsBrand = {"I don't go by brand", "sony", "intex", "samsung", "asus", "noise", "motorola", "apple", "lenovo", "ZTE"};
        ArrayAdapter<String> arrayAdapterBrand = new ArrayAdapter<String>(SmartWearables.this, R.layout.spinner_row, itemsBrand);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownBrand.setAdapter(arrayAdapterBrand);
        dropdownBrand.setOnItemSelectedListener(this);

        //adapter for whom
        dropdownFor = (Spinner) findViewById(R.id.forGenderWatch);
        String[] itemsRam = {"Men", "women", "kids", "Unisex"};
        ArrayAdapter<String> arrayAdapterFor = new ArrayAdapter<String>(SmartWearables.this, R.layout.spinner_row, itemsRam);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownFor.setAdapter(arrayAdapterFor);
        dropdownFor.setOnItemSelectedListener(this);

        //adapter for display type
        dropdownDisplayType = (Spinner) findViewById(R.id.displayTypeWatch);
        String[] itemsInternal = {"AMOLED", "DOT Matrix", "HD", "LCD", "IPS", "LED", "OLED","Super AMOLED"};
        ArrayAdapter<String> arrayAdapterdisplaytype = new ArrayAdapter<String>(SmartWearables.this, R.layout.spinner_row, itemsInternal);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownDisplayType.setAdapter(arrayAdapterdisplaytype);
        dropdownDisplayType.setOnItemSelectedListener(this);

        dropdownsort = (Spinner) findViewById(R.id.sortbyWatch);
        String[] itemsSort = {"Relevance", "Popularity", "Price-High to low", "Price-Low to high", "Newest first"};
        ArrayAdapter<String> arrayAdaptersort = new ArrayAdapter<String>(SmartWearables.this, R.layout.spinner_row, itemsSort);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownsort.setAdapter(arrayAdaptersort);
        dropdownsort.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.searchMethodWatch:{
                if(((String) parent.getItemAtPosition(position)).equals("Search by Keyword")) {
                    editText.setVisibility(View.VISIBLE);
                    dropdownBrand.setVisibility(View.GONE);
                    dropdownDisplayType.setVisibility(View.GONE);
                    dropdownFor.setVisibility(View.GONE);


                    flag=0;
                }
                else{
                    dropdownBrand.setVisibility(View.VISIBLE);
                    dropdownDisplayType.setVisibility(View.VISIBLE);
                    dropdownFor.setVisibility(View.VISIBLE);
                    //dropdownsort.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.GONE);
                    flag=1;
                }
            }
            break;
            case R.id.brandNameWatch:
                brand = (String) parent.getItemAtPosition(position);
                //Toast.makeText(parent.getContext(),"selected brand:"+brand,Toast.LENGTH_LONG).show();
                break;
            case R.id.displayTypeWatch:
                displaytype = (String) parent.getItemAtPosition(position);

                break;
            case R.id.forGenderWatch:
                formorw = (String) parent.getItemAtPosition(position);
                break;

            case R.id.sortbyWatch:
                sort = (String) parent.getItemAtPosition(position);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void searchMobilesAccessory(View view) {
        if(flag==0)
            output=editText.getText().toString();
        else if (flag==1 && brand.equals("I don't go by brand")) {
            output = "smart watch for "+formorw+" "+displaytype;
            //Toast.makeText(Mobiles.this, output, Toast.LENGTH_LONG).show();
        } else {
            output = brand + " smart watch for "+formorw+" "+displaytype;
            //Toast.makeText(Mobiles.this, output, Toast.LENGTH_LONG).show();
        }

        if (sort.equals("Relevance")) {
            flipkart += "&q=" + output;

            amazon+="sr_st_relevanceblender";
            amazon+="?keywords="+output;
            amazon+="&sort=relevanceblender";

            snapdeal+=output+"&sort=rlvncy";
        }
        else if (sort.equals("Popularity")) {
            flipkart += "&p%5B%5D=sort%3Dpopularity" + "&q=" + output;
            amazon+="ref=sr_st_review-rank";
            amazon+="?keywords="+output;
            amazon+="&sort=review-rank";

            snapdeal+=output+"&sort=plrty";
        }
        else if (sort.equals("Price-High to low")) {
            flipkart += "&p%5B%5D=sort%3Dprice_desc" + "&q=" + output;
            amazon+="ref=sr_st_price-desc-rank";
            amazon+="?keywords="+output;
            amazon+="&sort=price-desc-rank";

            snapdeal+=output+"&sort=phtl";
        }
        else if (sort.equals("Price-Low to high")) {
            flipkart += "&p%5B%5D=sort%3Dprice_asc" + "&q=" + output;
            amazon+="ref=sr_st_price-asc-rank";
            amazon+="?keywords="+output;
            amazon+="&sort=price-asc-rank";

            snapdeal+=output+"&sort=plth";
        }
        else if (sort.equals("Newest first")) {
            flipkart += "&p%5B%5D=sort%3Drecency_desc" + "&q=" + output;
            amazon+="ref=sr_st_date-desc-rank";
            amazon+="?keywords="+output;
            amazon+="&sort=date-desc-rank";
            snapdeal+=output+"&sort=rec";
        }
        Intent i=new Intent(this,ShoppingActivity.class);
        i.putExtra("flipkart",flipkart);
        i.putExtra("amazon",amazon);
        i.putExtra("snapdeal",snapdeal);
        flipkart="https://www.flipkart.com/search?as=off&as-show=on&count=40&otracker=start";
        amazon="https://www.amazon.in/s/ref=";
        snapdeal="https://www.snapdeal.com/search?keyword=";
        startActivity(i);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
        super.onBackPressed();
        Intent i=new Intent(SmartWearables.this,Electronics.class);
        startActivity(i);
        finish();
    }
}
