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
    TextView tv_tip, tv_people, tv_tip_output, tv_total_output;
    Button b_calculate, b_tip_minus, b_tip_plus, b_PEOPLE_minus, b_PEOPLE_plus;

    int tipPercent = 0;
    int peopleCount = 1;
    double billInit = 100.00;
    double tipOutput = 0;
    double totalOutput = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Amount = findViewById(R.id.et_Amount);
        tv_tip = findViewById(R.id.tv_tip);
        tv_tip_output=findViewById(R.id.tv_tip_output);
        tv_total_output=findViewById(R.id.tv_total_output);
        b_calculate=findViewById(R.id.b_calculate);
        b_tip_minus=findViewById(R.id.b_tip_minus);
        b_tip_plus=findViewById(R.id.b_tip_plus);
        b_PEOPLE_minus=findViewById(R.id.b_PEOPLE_minus);
        b_PEOPLE_plus=findViewById(R.id.b_PEOPLE_plus);

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
                    et_Amount.setText(String.format(Locale.getDefault(), "0.2f", billInit));

                    //calculate the tip
                    tipOutput = (billInit * tipPercent) / 100;
                    //format the number
                    tipOutput = tipOutput*100;
                    tipOutput = Math.round(tipOutput);
                    tipOutput = tipOutput/100;

                    if (peopleCount == 1){
                    //show the total tip
                    tv_tip_output.setText(String.format(Locale.getDefault(), "0.2f", tipOutput));

                    //show the total bill including the tip
                    totalOutput = billInit + tipOutput;
                    tv_total_output.setText(String.format(Locale.getDefault(), "0.2f", totalOutput));
                } else {
                        //show the total bill including the tip
                        totalOutput = billInit + tipOutput;
                        totalOutput = totalOutput / peopleCount;
                        tv_total_output.setText(String.format(Locale.getDefault(), "0.2f", totalOutput) + " per person");

                        //show the total tip
                        tipOutput = tipOutput / peopleCount;
                        tv_tip_output.setText(String.format(Locale.getDefault(), "0.2f", tipOutput) + " per person");
                    }
                }
            }
        });

        b_tip_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipPercent > 0) {
                    tipPercent--;
                    tv_tip.setText(tipPercent + "0");
                }
            }
        });

        b_tip_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPercent++;
                tv_tip.setText(tipPercent + "0");

            }
        });

        b_PEOPLE_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (peopleCount> 1) {
                   peopleCount--;
                   tv_people.setText(peopleCount + "");
                }

            }
        });

        b_PEOPLE_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peopleCount++;
                tv_people.setText(peopleCount + "");

            }
        });


    }
}