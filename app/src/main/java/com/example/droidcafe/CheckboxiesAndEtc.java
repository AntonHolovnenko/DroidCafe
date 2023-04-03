package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class CheckboxiesAndEtc extends AppCompatActivity {

    String string = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboxies_and_etc);
    }

    public void backToOrder(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    public void itemClicked(View view) {
        //code to check if this checkbox is checked!
        CheckBox chokolate_syrup = findViewById(R.id.chokolate_syrup);
        CheckBox sprinkles = findViewById(R.id.sprinkles);
        CheckBox crushed_nuts = findViewById(R.id.crushed_nuts);
        CheckBox cherries = findViewById(R.id.cherries);
        CheckBox oreo_cookie_crumbles = findViewById(R.id.oreo_cookie_crumbles);


        if(chokolate_syrup.isChecked()){
            string += ((CheckBox) findViewById(R.id.chokolate_syrup)).getText() + " ";
        }else if(sprinkles.isChecked()){
            string += ((CheckBox) findViewById(R.id.sprinkles)).getText() + " ";
        }else if(crushed_nuts.isChecked()){
            string += ((CheckBox) findViewById(R.id.crushed_nuts)).getText() + " ";
        }else if(cherries.isChecked()){
            string += ((CheckBox) findViewById(R.id.cherries)).getText() + " ";
        }else if(oreo_cookie_crumbles.isChecked()){
            string += ((CheckBox) findViewById(R.id.oreo_cookie_crumbles)).getText() + " ";
        }


    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("CutPasteId")
    public void toast(View view) {
        itemClicked(view);
        displayToast(string);


    }
}