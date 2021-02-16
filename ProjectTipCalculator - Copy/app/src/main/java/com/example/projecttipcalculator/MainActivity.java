package com.example.projecttipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText et_Amount;
    TextView tv_tip_output;
    Button b_calculate;

    double tip10 = 0.1;
    double tip15 = 0.15;
    double tip20 = 0.2;

    double billInit = 100.00;
    double tipOutput = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Amount = findViewById(R.id.et_Amount);
        tv_tip_output = findViewById(R.id.tv_tip_output);
        b_calculate = findViewById(R.id.b_calculate);

        b_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String billString = et_Amount.getText().toString();
                if (!billString.equals("")) {
                    //this is the initial bill
                    billInit = Double.valueOf(billString);
                    //format the number
                    billInit = billInit*100;
                    billInit = Math.round(billInit);
                    billInit = billInit/100;
                    //show the formatted bill
                    et_Amount.setText(String.format(Locale.US,"0.2f", billInit));
                    tv_tip_output.setText("The tips are as follows:");

                    //calculate the tip
                    tipOutput = billInit * tip10;
                    //format the number

                    tipOutput = Math.round(tipOutput);



                }
            }
        });




    }
}