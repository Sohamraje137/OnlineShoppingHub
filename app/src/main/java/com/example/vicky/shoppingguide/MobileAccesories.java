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

public class MobileAccesories extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String flipkart = "https://www.flipkart.com/search?as=off&as-show=on&count=40&otracker=start";
    String amazon="https://www.amazon.in/s/ref=";
    String snapdeal="https://www.snapdeal.com/search?keyword=";
    String output = "";
    int flag;
    String mobileaccesories= "",Productdetails="", sort = "";
    String method="";
    ActionBar actionBar;
    Spinner dropdownMethod,dropdownitem, dropdownsort;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobileaccesories);

        actionBar =getSupportActionBar();
        actionBar.setTitle("Mobile Accessories");
        actionBar.setDisplayHomeAsUpEnabled(true);

        editText=(EditText) findViewById(R.id.mobileAccessoriesProductDetail);

        dropdownitem= (Spinner) findViewById(R.id.mobileAccesoriesItem);
        String[] itemsname = {"earphones", "battery", "screen covers", "Memory Card", "Charger"};
        ArrayAdapter<String> arrayAdapterBrand = new ArrayAdapter<String>(MobileAccesories.this, R.layout.spinner_row, itemsname);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownitem.setAdapter(arrayAdapterBrand);
        dropdownitem.setOnItemSelectedListener(this);

        dropdownsort = (Spinner) findViewById(R.id.sortbyMobileAccesories);
        String[] itemsSort = {"Relevance", "Popularity", "Price-High to low", "Price-Low to high", "Newest first"};
        ArrayAdapter<String> arrayAdaptersort = new ArrayAdapter<String>(MobileAccesories.this, R.layout.spinner_row, itemsSort);
        arrayAdapterBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownsort.setAdapter(arrayAdaptersort);
        dropdownsort.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parentMA, View view, int i, long l) {

        switch (parentMA.getId()){
            case R.id.mobileAccesoriesItem:
                                      Productdetails=(String) parentMA.getItemAtPosition(i);
                                        break;
            case R.id.sortbyMobileAccesories:

                                           sort = (String) parentMA.getItemAtPosition(i);
                                           break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void searchMobileAccesories(View view) {
            output= editText.getText().toString()+" "+Productdetails;

        if(sort.equals("Relevance")){
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

        Intent i=new Intent(MobileAccesories.this,Electronics.class);
        startActivity(i);
        finish();
    }
}

