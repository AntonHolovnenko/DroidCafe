package com.example.droidcafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
        string = "";
        //code to check if this checkbox is checked!
        CheckBox chokolate_syrup = findViewById(R.id.chokolate_syrup);
        CheckBox sprinkles = findViewById(R.id.sprinkles);
        CheckBox crushed_nuts = findViewById(R.id.crushed_nuts);
        CheckBox cherries = findViewById(R.id.cherries);
        CheckBox oreo_cookie_crumbles = findViewById(R.id.oreo_cookie_crumbles);

        if(chokolate_syrup.isChecked()){
            string += ((CheckBox) findViewById(R.id.chokolate_syrup)).getText() + " ";
        }if(sprinkles.isChecked()){
            string += ((CheckBox) findViewById(R.id.sprinkles)).getText() + " ";
        }if(crushed_nuts.isChecked()){
            string += ((CheckBox) findViewById(R.id.crushed_nuts)).getText() + " ";
        }if(cherries.isChecked()){
            string += ((CheckBox) findViewById(R.id.cherries)).getText() + " ";
        }if(oreo_cookie_crumbles.isChecked()){
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

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(CheckboxiesAndEtc.this);
        // Set the dialog title and message.
        myAlertBuilder.setTitle("Alert");
        myAlertBuilder.setMessage("Click OK to continue, or Cancel to stop:");
// Add the dialog buttons.
        myAlertBuilder.setPositiveButton("OK", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked the OK button.
                        Toast.makeText(getApplicationContext(), "Pressed OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.setNegativeButton("Cancel", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), "Pressed Cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
// Create and show the AlertDialog.
        myAlertBuilder.show();
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String timeMessage = (hour_string + ":" + minute_string);
        Toast.makeText(this, "Time: " + timeMessage, Toast.LENGTH_SHORT).show();
    }

    public void goToTab(View view) {
        Intent intent = new Intent(this, TabExperiment.class);
        startActivity(intent);
    }
}