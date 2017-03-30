package com.example.vivek.interestcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button simpleInterest;
    private Button compoundInterest;
    private Button emiCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleInterest = (Button) findViewById(R.id.SimpleInterest);
        compoundInterest = (Button) findViewById(R.id.CompoundInterest);
        emiCalculator = (Button) findViewById(R.id.EMICalculator);

        simpleInterest.setOnClickListener(this);
        compoundInterest.setOnClickListener(this);
        emiCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == simpleInterest){
            Intent si = new Intent(this, SimpleInterestCalculatorActivity.class);
            startActivity(si);
        }
        else if(v == compoundInterest){
            Intent ci = new Intent(this, CompoundIntrestCalcualtorActivity.class);
            startActivity(ci);
        }
        else if(v == emiCalculator){
            Intent ec = new Intent(this, EMICalcualtorActivity.class);
            startActivity(ec);
        }

    }
}
