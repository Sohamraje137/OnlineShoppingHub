package com.example.vicky.shoppingguide;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by vicky on 20/2/18.
 */

public class FirstLaunchApplication extends AppCompatActivity {

    String mypreference="mypref";
    SharedPreferences sharedpreferences;
    EditText first,last;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_time_login);
        first= (EditText) findViewById(R.id.firstName);
        last= (EditText) findViewById(R.id.LastName);
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        sharedpreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);


    }

    public void onNextClick(View view) {
        String value=((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        String firstName=first.getText().toString();
        String LastName=last.getText().toString();
        SharedPreferences.Editor editor=sharedpreferences.edit();
        editor.putString("firstName",firstName);
        editor.putString("lastName",LastName);
        editor.putString("gender",value);
        editor.commit();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
