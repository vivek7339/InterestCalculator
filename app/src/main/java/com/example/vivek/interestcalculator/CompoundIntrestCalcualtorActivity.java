package com.example.vivek.interestcalculator;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import java.text.DecimalFormat;

public class CompoundIntrestCalcualtorActivity extends AppCompatActivity implements OnClickListener {

    private EditText principalAmount, interestRate, termInYears, noInterestPayments;
    private Button calculate, reset, back;
    private TextView resultCompoundInterest, resultAccumlatedAmount, printError;
    private Toolbar myToolbar;

    static  final  String LOG_TAG = "CICActivity";
    generalfunctions hk = new generalfunctions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_intrest_calcualtor);

        myToolbar = (Toolbar) findViewById(R.id.CICToolbar);
        myToolbar.setTitle("Compound Interest Calculator");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.inflateMenu(R.menu.mainmenu);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuAbout:
                        Log.v(LOG_TAG,"About Activity Started");
                        Intent si = new Intent(CompoundIntrestCalcualtorActivity.this, About.class);
                        startActivity(si);
                        return true;
                    case R.id.menuContactUs:
                        Log.v(LOG_TAG,"Contact Activity Started");
                        Intent cu = new Intent(CompoundIntrestCalcualtorActivity.this, ContactUs.class);
                        startActivity(cu);
                        return true;
                }
                return false;
            }
        });

        generalfunctions hk = new generalfunctions();
        hk.hidekeyboard(this);
        principalAmount = (EditText) findViewById(R.id.PrincipalAmountForCI);
        interestRate = (EditText) findViewById(R.id.InterestRateForCI);
        termInYears = (EditText) findViewById(R.id.TermInYearsForCI);
        noInterestPayments = (EditText) findViewById(R.id.NoInterestPaymentsForCI);
        calculate = (Button) findViewById(R.id.CalculateForCI);
        reset = (Button) findViewById(R.id.ResetForCI);
        back = (Button) findViewById(R.id.BackForCI);
        resultCompoundInterest = (TextView) findViewById(R.id.ResultCompoundInterest);
        resultAccumlatedAmount = (TextView) findViewById(R.id.ResultAccumlatedAmount);
        printError = (TextView) findViewById(R.id.PrintErrorCI);

        calculate.setOnClickListener(this);
        reset.setOnClickListener(this);
        back.setOnClickListener(this);
        Log.v(LOG_TAG,"Activity Started");
    }

    @Override
    public void onClick(View v) {

        if(v == calculate){
            CalculateCompoundInterest();
        }
        else if(v == reset){
           reset();
        }
        else if(v == back){
            Intent ma = new Intent(this, MainActivity.class);
            startActivity(ma);
        }

    }

    private void reset() {
        Log.v(LOG_TAG,"Reset");
        hk.hidekeyboard(this);
        principalAmount.getText().clear();
        interestRate.getText().clear();
        termInYears.getText().clear();
        noInterestPayments.getText().clear();
        resultCompoundInterest.setText(null);
        resultAccumlatedAmount.setText(null);
        printError.setText(null);
    }

    private void CalculateCompoundInterest() {
        if(principalAmount.getText().toString().isEmpty() || interestRate.getText().toString().isEmpty() ||  termInYears.getText().toString().isEmpty() || noInterestPayments.getText().toString().isEmpty()){
            reset();
            printError.setText(R.string.Error_Message);
            hk.hidekeyboard(this);
        }
        else{
            Log.v(LOG_TAG,"CI Calculated");
            hk.hidekeyboard(this);
            DecimalFormat df = new DecimalFormat("0.00");
            int p = Integer.parseInt(principalAmount.getText().toString());
            Float r  = Float.parseFloat(interestRate.getText().toString())/100;
            int t = Integer.parseInt(termInYears.getText().toString());
            int n = Integer.parseInt(noInterestPayments.getText().toString());
            Double totalPayment = p * (Math.pow((1+(r/n)),(n * t)));
            Double compoundInterest = totalPayment - p;
            resultCompoundInterest.setText(df.format(compoundInterest));
            resultAccumlatedAmount.setText(df.format(totalPayment));
            printError.setText(null);
        }

    }

}
