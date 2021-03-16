package com.example.projecttipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText; 
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateTips(View view) {

        EditText et_Amount = findViewById(R.id.et_Amount);
        TextView tipWord = findViewById(R.id.tipWord);
        TextView tip10 = findViewById(R.id.tip10);
        TextView tip15 = findViewById(R.id.tip15);
        TextView tip20 = findViewById(R.id.tip20);

        if(!et_Amount.getText().toString().equals("")){

            float tip_10 = 0.1F* Float.valueOf(et_Amount.getText().toString());
            float tip_15 = 0.15F* Float.valueOf(et_Amount.getText().toString());
            float tip_20 = 0.2F* Float.valueOf(et_Amount.getText().toString());
            tipWord.setText("The tips are as following:");
            tip10.setText("Ten percent tips = "+String.format(Locale.getDefault(),"%.2f",tip_10));
            tip15.setText("Fifteen percent tips = "+String.format(Locale.getDefault(),"%.2f",tip_15));
            tip20.setText("Twenty percent tips = "+String.format(Locale.getDefault(),"%.2f",tip_20));
        } else {
            tipWord.setText("Please enter a number");
            tip10.setText(R.string.no_value_string);
            tip15.setText(R.string.no_value_string);
            tip20.setText(R.string.no_value_string);

        }
    }

}