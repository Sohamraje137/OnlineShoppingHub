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
 * Created by Soham on 13/10/17.
 */

public class Laptops extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String flipkart = "https://www.flipkart.com/search?as=off&as-show=on&count=40&otracker=start";
    String amazon = "https://www.amazon.in/s/ref=";
    String snapdeal = "https://www.snapdeal.com/search?keyword=";
    String output = "";
    int flag;

    String Brand = "", RAM = "", internal = "", Graphics = "", Processor = "", sort = "";
    String graphicbrand = "", touch = "", screen = "", processorbrand = "", speciality = "";
    ActionBar actionBarLaptop;

    Spinner dropdownSearchMethod, dropdownBrand, dropdownRAM, dropdownInternal, dropdownGraphics, dropdownProcessor, dropdownsort;
    Spinner dropdownspeciality, dropdownscreensize, dropdowntouch, dropdownprocessorbrand;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptops);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Laptop Specification");
        actionBar.setDisplayHomeAsUpEnabled(true);


        editText= (EditText) findViewById(R.id.laptopproductKeyword);//search method
        /*

        //adapter for brand only*/
        dropdownSearchMethod = (Spinner) findViewById(R.id.LaptopsearchMethod);
        String[] searchMethod = {"Search by keyword", "Search by Specification"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, searchMethod);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownSearchMethod.setAdapter(arrayAdapter);
        dropdownSearchMethod.setOnItemSelectedListener(this);

//brand
        dropdownBrand = (Spinner) findViewById(R.id.laptopbrandName);
        String[] laptopBrand = {"Brand independent", "Dell", "MAC BOOK", "HP", "ACER", "LENEVO", "ALIEN WARE", "OTHER BRANDs"};
        ArrayAdapter<String> laptopbrandarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, laptopBrand);
        laptopbrandarrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownBrand.setAdapter(laptopbrandarrayAdapter);
        dropdownBrand.setOnItemSelectedListener(this);

//Speciality
        dropdownspeciality = (Spinner) findViewById(R.id.laptopspeciality);
        String[] laptopspeciality = {"Browsing and email", "Bussiness", "Gaming", "High performance", "Light weight"};
        ArrayAdapter<String> laptopspecialityarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, laptopspeciality);
      laptopspecialityarrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownspeciality.setAdapter(laptopspecialityarrayAdapter);
        dropdownspeciality.setOnItemSelectedListener(this);

        //screensizelaptop
        dropdownscreensize = (Spinner) findViewById(R.id.screensizeLaptop);
        String[] laptopscreensize = {"No specific size", "15 inch-15.9 inch", "14 inch-14.9 inch", "13 inch-13.9 inch", "12 inch-12.9inch", "16 inch-17.9inch", "Below 12 inch", "Above 20 inch"};
        ArrayAdapter<String> laptopscreensizearrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, laptopscreensize);
        laptopscreensizearrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownscreensize.setAdapter(laptopscreensizearrayAdapter);
        dropdownscreensize.setOnItemSelectedListener(this);


//touchscreenlaptop
        dropdowntouch = (Spinner) findViewById(R.id.touchscreenLaptop);
        String[] laptoptouch = {"Doesn't matter", "Yes", "No"};
        ArrayAdapter<String> laptoptouchscreenarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, laptoptouch);
        laptoptouchscreenarrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdowntouch.setAdapter(laptoptouchscreenarrayAdapter);
        dropdowntouch.setOnItemSelectedListener(this);


//ram
        dropdownRAM = (Spinner) findViewById(R.id.ramLaptop);
        String[] ram = {"2GB", "4GB", "8GB", "16GB"};
        ArrayAdapter<String> laptopramarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, ram);
        laptopbrandarrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownRAM.setAdapter(laptopramarrayAdapter);
        dropdownRAM.setOnItemSelectedListener(this);
//internal
        dropdownInternal = (Spinner) findViewById(R.id.internalLaptop);
        String[] internal = {"256GB", "512GB", "1TB", "2TB"};
        ArrayAdapter<String> laptopinternalarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, internal);
        laptopinternalarrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownInternal.setAdapter(laptopinternalarrayAdapter);
        dropdownInternal.setOnItemSelectedListener(this);

//graphics memory
        dropdownGraphics = (Spinner) findViewById(R.id.laptopgraphic);
        String[] graphics = {"Integrated Graphics Card", "2 GB", "4GB", "8GB"};
        ArrayAdapter<String> laptopgraphicsarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, graphics);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownGraphics.setAdapter(laptopgraphicsarrayAdapter);
        dropdownGraphics.setOnItemSelectedListener(this);

//processor type
        dropdownProcessor = (Spinner) findViewById(R.id.Laptopprocessor);
        String[] processor = {"Core i3", "Core i5", "Core i7", "Pentium Quad Core"};
        ArrayAdapter<String> laptopprocessorarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, processor);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownProcessor.setAdapter(laptopprocessorarrayAdapter);
        dropdownProcessor.setOnItemSelectedListener(this);


//processor brand

        dropdownprocessorbrand = (Spinner) findViewById(R.id.processorbrandLaptop);
        String[] processorbrand = {"Intel", "AMD", "NVIDIA", "ARM"};
        ArrayAdapter<String> laptopprocessorbrandarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, processorbrand);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownprocessorbrand.setAdapter(laptopprocessorbrandarrayAdapter);
        dropdownprocessorbrand.setOnItemSelectedListener(this);


//sort
        dropdownsort = (Spinner) findViewById(R.id.sortbyLaptop);
        String[] sortlaptop = {"Relevance", "Popularity", "Price-High to low", "Price-Low to high", "Newest first"};
        ArrayAdapter<String> laptopsortarrayAdapter = new ArrayAdapter<>(Laptops.this, R.layout.spinner_row, sortlaptop);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownsort.setAdapter(laptopsortarrayAdapter);
        dropdownsort.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

        switch (parent.getId()) {

            case R.id.LaptopsearchMethod: {
                if (((String) parent.getItemAtPosition(i)).equals("Search by keyword")) {

                    editText.setVisibility(View.VISIBLE);
                    dropdownBrand.setVisibility(View.GONE);
                    dropdownRAM.setVisibility(View.GONE);
                    dropdownInternal.setVisibility(View.GONE);
                    dropdownspeciality.setVisibility(View.GONE);
                    dropdownscreensize.setVisibility(View.GONE);
                    dropdowntouch.setVisibility(View.GONE);
                    dropdownprocessorbrand.setVisibility(View.GONE);
                    dropdownGraphics.setVisibility(View.GONE);
                    dropdownProcessor.setVisibility(View.GONE);

                    flag = 0;
                } else {
                    flag = 1;
                    editText.setVisibility(View.GONE);
                    dropdownBrand.setVisibility(View.VISIBLE);
                    dropdownRAM.setVisibility(View.VISIBLE);
                    dropdownInternal.setVisibility(View.VISIBLE);
                    dropdownspeciality.setVisibility(View.VISIBLE);
                    dropdownscreensize.setVisibility(View.VISIBLE);
                    dropdowntouch.setVisibility(View.VISIBLE);
                    dropdownprocessorbrand.setVisibility(View.VISIBLE);
                    dropdownGraphics.setVisibility(View.VISIBLE);
                    dropdownProcessor.setVisibility(View.VISIBLE);
                        flag=1;
                }
                break;
            }

            case R.id.laptopbrandName:
                Brand = (String) parent.getItemAtPosition(i);
                break;

            case R.id.ramLaptop:
                RAM = (String) parent.getItemAtPosition(i);
                break;

            case R.id.internalLaptop:
                internal = (String) parent.getItemAtPosition(i);
                break;

            case R.id.laptopgraphic:
                Graphics = (String) parent.getItemAtPosition(i);
                break;


            case R.id.laptopspeciality:
                speciality = (String) parent.getItemAtPosition(i);
                break;

            case R.id.touchscreenLaptop:
                if (((String) parent.getItemAtPosition(i)).equals("Yes")) {
                    touch = "Touch screen";
                }
                break;
            case R.id.screenSize:
                screen = (String) parent.getItemAtPosition(i);
                break;

            case R.id.Laptopprocessor:
                Processor = (String) parent.getItemAtPosition(i);
                break;

            case R.id.processorbrandLaptop:
                processorbrand = (String) parent.getItemAtPosition(i);
                break;

            case R.id.sortbyLaptop:
                sort = (String) parent.getItemAtPosition(i);
                break;
        }
    }

         @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }

        public void searchLaptop (View view)
        {
            if (flag == 0) {
                output = editText.getText().toString();
            } else if (flag == 1 && (Brand.equals("Brand independent") ||Brand.equals("OTHER BRANDs"))) {
                output = " Laptop " + "system_memory" + RAM + internal + " internal " + touch + "touch screen" + screen + " screen_size " + screen + "processor" + Processor + "processor_brand" + processorbrand + "dedicated_graphics_memory" + Graphics + "graphic_processor_name" + graphicbrand;
                //Toast.makeText(Mobiles.this, output, Toast.LENGTH_LONG).show();
            } else {
                output = Brand + " Laptop " + "system memory" + RAM + internal + " internal " + touch + "touch screen" + screen + " screen_size " + screen + "processor" + Processor + "processor_brand" + processorbrand + "dedicated_graphics_memory" + Graphics + "graphic_processor_name" + graphicbrand;
                //Toast.makeText(Mobiles.this, output, Toast.LENGTH_LONG).show();
            }

            if (sort.equals("Relevance")) {
                flipkart += "&q=" + output;

                amazon += "sr_st_relevanceblender";
                amazon += "?keywords=" + output;
                amazon += "&sort=relevanceblender";

                snapdeal += output + "&sort=rlvncy";
            } else if (sort.equals("Popularity")) {
                flipkart += "&p%5B%5D=sort%3Dpopularity" + "&q=" + output;
                amazon += "ref=sr_st_review-rank";
                amazon += "?keywords=" + output;
                amazon += "&sort=review-rank";

                snapdeal += output + "&sort=plrty";
            } else if (sort.equals("Price-High to low")) {
                flipkart += "&p%5B%5D=sort%3Dprice_desc" + "&q=" + output;
                amazon += "ref=sr_st_price-desc-rank";
                amazon += "?keywords=" + output;
                amazon += "&sort=price-desc-rank";

                snapdeal += output + "&sort=phtl";
            } else if (sort.equals("Price-Low to high")) {
                flipkart += "&p%5B%5D=sort%3Dprice_asc" + "&q=" + output;
                amazon += "ref=sr_st_price-asc-rank";
                amazon += "?keywords=" + output;
                amazon += "&sort=price-asc-rank";

                snapdeal += output + "&sort=plth";
            } else if (sort.equals("Newest first")) {
                flipkart += "&p%5B%5D=sort%3Drecency_desc" + "&q=" + output;
                amazon += "ref=sr_st_date-desc-rank";
                amazon += "?keywords=" + output;
                amazon += "&sort=date-desc-rank";
                snapdeal += output + "&sort=rec";
            }


            Intent i = new Intent(this, ShoppingActivity.class);
            i.putExtra("flipkart", flipkart);
            i.putExtra("amazon", amazon);
            i.putExtra("snapdeal", snapdeal);
            flipkart = "https://www.flipkart.com/search?as=off&as-show=on&count=40&otracker=start";
            amazon = "https://www.amazon.in/s/ref=";
            snapdeal = "https://www.snapdeal.com/search?keyword=";
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
        super.onBackPressed();
        Intent i=new Intent(Laptops.this,Electronics.class);
        startActivity(i);
        finish();
    }

}