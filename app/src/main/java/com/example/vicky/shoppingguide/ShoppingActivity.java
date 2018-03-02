package com.example.vicky.shoppingguide;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
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
import android.widget.Toast;

public class ShoppingActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButtonFK,floatingActionButtonAM,floatingActionButtonSD;

    ActionBar actionBar;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    static  final String TAG="Main";
    String flipkart="";
    String amazon="";
    String snapdeal="";
    private ViewPager mViewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Compare!!");
        actionBar.setDisplayHomeAsUpEnabled(true);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


        Bundle bundle=getIntent().getExtras();
        flipkart=bundle.getString("flipkart");
        amazon=bundle.getString("amazon");
        snapdeal=bundle.getString("snapdeal");

        floatingActionButtonAM= (FloatingActionButton) findViewById(R.id.wishListAmazon);
        floatingActionButtonFK= (FloatingActionButton) findViewById(R.id.wishListFlipkart);
        floatingActionButtonSD= (FloatingActionButton) findViewById(R.id.wishListSnapdeal);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                animateFab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                animateFab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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

    private void animateFab(int position) {
        switch (position) {
            case 0:
                floatingActionButtonAM.hide();
                floatingActionButtonFK.show();
                floatingActionButtonSD.hide();
                break;
            case 1:
                floatingActionButtonAM.show();
                floatingActionButtonFK.hide();
                floatingActionButtonSD.hide();
                break;
            case 2:
                floatingActionButtonAM.hide();
                floatingActionButtonFK.hide();
                floatingActionButtonSD.show();
                break;
            default:
                floatingActionButtonAM.hide();
                floatingActionButtonFK.show();
                floatingActionButtonSD.hide();


        }
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
