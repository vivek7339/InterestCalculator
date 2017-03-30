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
    private TextView resultSimpleInterest, resultTotalPayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest_calculator);

        principalAmount = (EditText) findViewById(R.id.PrincipalAmountInput);
        interestRate = (EditText) findViewById(R.id.IntrestRate);
        termInYears = (EditText) findViewById(R.id.TermInYears);
        calculate = (Button) findViewById(R.id.Calculate);
        reset = (Button) findViewById(R.id.Reset);
        back = (Button) findViewById(R.id.Back);
        resultSimpleInterest = (TextView) findViewById(R.id.SimpleInterestResult);
        resultTotalPayment = (TextView) findViewById(R.id.TotalPaymentResult);

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
            Intent si = new Intent(this, SimpleInterestCalculatorActivity.class);
            startActivity(si);
        }
        else if(v == back){
            Intent ma = new Intent(this, MainActivity.class);
            startActivity(ma);
        }

    }

    private void CalculateInterest() {
        int amount = Integer.parseInt(principalAmount.getText().toString());
        Float interest  = Float.parseFloat(interestRate.getText().toString());
        int loanTerm = Integer.parseInt(termInYears.getText().toString());
        Float DueInterest = amount * loanTerm * interest /100;
        Float totalPayment = amount + DueInterest;
        resultSimpleInterest.setText(Float.toString(DueInterest));
        resultTotalPayment.setText(Float.toString(totalPayment));

    }
}
