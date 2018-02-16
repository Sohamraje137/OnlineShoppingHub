package com.example.vicky.shoppingguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by vicky on 4/10/17.
 */

public class Categories extends Fragment {
    GridView gridView;
    String[] gridViewString ={"Electronics","Appliances","Men","Women","Baby and Kids","Books and more.."
            };
    int[] gridViewImageId={
            R.drawable.electronics,R.drawable.appliances,R.drawable.man,R.drawable.women,R.drawable.baby_and_kids,
            R.drawable.books_and_more
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.categories,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CustomAdaptorGridCategories customAdaptorGridCategories=new CustomAdaptorGridCategories(getActivity(),gridViewString,gridViewImageId);
        gridView=(GridView)view.findViewById(R.id.gridViewCategories);
        gridView.setAdapter(customAdaptorGridCategories);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(gridViewString[position]=="Electronics")
                    startActivity(new Intent(getActivity(),Electronics.class));
                if(gridViewString[position]=="Appliances")
                    startActivity(new Intent(getActivity(),Appliances.class));
                if(gridViewString[position]=="Men")
                    startActivity(new Intent(getActivity(),Men.class));
                if(gridViewString[position]=="Women")
                    startActivity(new Intent(getActivity(),Women.class));
                if(gridViewString[position]=="Baby and Kids")
                    startActivity(new Intent(getActivity(),BabyAndKids.class));
                if(gridViewString[position]=="Books and more..")
                    startActivity(new Intent(getActivity(),BooksMore.class));
            }
        });

    }
}
