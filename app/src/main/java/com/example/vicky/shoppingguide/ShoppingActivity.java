package com.example.vicky.shoppingguide;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    static  final String TAG="Main";
    String flipkart="";
    String amazon="";
    String snapdeal="";
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


        Bundle bundle=getIntent().getExtras();
        flipkart=bundle.getString("flipkart");
        amazon=bundle.getString("amazon");
        snapdeal=bundle.getString("snapdeal");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping, menu);
        return true;
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
        }

        return super.onOptionsItemSelected(item);
    }




    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
          switch (position){
              case 0:
                  Bundle b=new Bundle();
                  b.putString("flipkart",flipkart);
                  FlipkartFragment ff=new FlipkartFragment();
                  ff.setArguments(b);
                  return ff;

              case 1:
                  Bundle b1=new Bundle();
                  b1.putString("amazon",amazon);
                  AmazonFragment af=new AmazonFragment();
                  af.setArguments(b1);
                  return af;
              case 2:
                  Bundle b2=new Bundle();
                  b2.putString("snapdeal",snapdeal);
                  SnapdealFragment sf=new SnapdealFragment();
                  sf.setArguments(b2);
                  return sf;
              default:return null;
          }

        }

        @Override
        public int getCount() {

            return 3;
        }
    }
}
