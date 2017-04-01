package com.example.vivek.interestcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import java.text.DecimalFormat;

public class SimpleInterestCalculatorActivity extends AppCompatActivity implements OnClickListener {

    private EditText principalAmount, interestRate, termInYears;
    private Button calculate, reset, back;
    private TextView resultSimpleInterest, resultTotalPayment, printError;
    static  final  String LOG_TAG = "SICActivity";
    generalfunctions hk = new generalfunctions();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest_calculator);

        generalfunctions hk = new generalfunctions();
        hk.hidekeyboard(this);
        principalAmount = (EditText) findViewById(R.id.PrincipalAmountInput);
        interestRate = (EditText) findViewById(R.id.IntrestRate);
        termInYears = (EditText) findViewById(R.id.TermInYearsForCI);
        calculate = (Button) findViewById(R.id.CalculateForCI);
        reset = (Button) findViewById(R.id.ResetForCI);
        back = (Button) findViewById(R.id.Back);
        resultSimpleInterest = (TextView) findViewById(R.id.SimpleInterestResult);
        resultTotalPayment = (TextView) findViewById(R.id.TotalPaymentResult);
        printError = (TextView) findViewById(R.id.PrintErrorSI);

        calculate.setOnClickListener(this);
        reset.setOnClickListener(this);
        back.setOnClickListener(this);

        Log.v(LOG_TAG,"Activity Created");
    }

    @Override
    public void onClick(View v) {

        if(v == calculate){
            CalculateInterest();

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
        hk.hidekeyboard(this);
        Log.v(LOG_TAG,"Reset");
        principalAmount.getText().clear();
        interestRate.getText().clear();
        termInYears.getText().clear();
        resultSimpleInterest.setText(null);
        resultTotalPayment.setText(null);
        printError.setText(null);
    }

    private void CalculateInterest() {

        if(principalAmount.getText().toString().isEmpty() || interestRate.getText().toString().isEmpty() ||  termInYears.getText().toString().isEmpty()){
            reset();
            printError.setText("Enter all Value");
            hk.hidekeyboard(this);
        }
        else{
            Log.v(LOG_TAG,"Simple Interest");
            hk.hidekeyboard(this);
            DecimalFormat df = new DecimalFormat("0.00");
            int amount = Integer.parseInt(principalAmount.getText().toString());
            Float interest  = Float.parseFloat(interestRate.getText().toString());
            int loanTerm = Integer.parseInt(termInYears.getText().toString());
            Float DueInterest = amount * loanTerm * interest /100;
            Float totalPayment = amount + DueInterest;
            resultSimpleInterest.setText(df.format(DueInterest));
            resultTotalPayment.setText(df.format(totalPayment));
            printError.setText(null);
        }


    }


}
