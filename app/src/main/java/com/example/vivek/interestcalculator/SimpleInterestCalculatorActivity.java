package com.example.vivek.interestcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class SimpleInterestCalculatorActivity extends AppCompatActivity implements OnClickListener {

    private EditText principalAmount, interestRate, termInYears;
    private Button calculate, reset, back;
    private TextView resultSimpleInterest, resultTotalPayment, printError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest_calculator);

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
        principalAmount.getText().clear();
        interestRate.getText().clear();
        termInYears.getText().clear();
        resultSimpleInterest.setText(null);
        resultTotalPayment.setText(null);
        principalAmount.setText(null);
    }

    private void CalculateInterest() {
        int amount = Integer.parseInt(principalAmount.getText().toString());
        Float interest  = Float.parseFloat(interestRate.getText().toString());
        int loanTerm = Integer.parseInt(termInYears.getText().toString());
        if(amount == 0 || interest == 0 || loanTerm ==0){
            reset();
            principalAmount.setText("Enter all Value");
        }
        else{
            Float DueInterest = amount * loanTerm * interest /100;
            Float totalPayment = amount + DueInterest;
            resultSimpleInterest.setText(Float.toString(DueInterest));
            resultTotalPayment.setText(Float.toString(totalPayment));
            principalAmount.setText(null);
        }


    }
}
