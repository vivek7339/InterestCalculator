package com.example.vivek.interestcalculator;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class CompoundIntrestCalcualtorActivity extends AppCompatActivity implements OnClickListener {

    private EditText principalAmount, interestRate, termInYears, noInterestPayments;
    private Button calculate, reset, back;
    private TextView resultCompoundInterest, resultAccumlatedAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_intrest_calcualtor);

        principalAmount = (EditText) findViewById(R.id.PrincipalAmountForCI);
        interestRate = (EditText) findViewById(R.id.InterestRateForCI);
        termInYears = (EditText) findViewById(R.id.TermInYearsForCI);
        noInterestPayments = (EditText) findViewById(R.id.NoInterestPaymentsForCI);
        calculate = (Button) findViewById(R.id.CalculateForCI);
        reset = (Button) findViewById(R.id.ResetForCI);
        back = (Button) findViewById(R.id.BackForCI);
        resultCompoundInterest = (TextView) findViewById(R.id.ResultCompoundInterest);
        resultAccumlatedAmount = (TextView) findViewById(R.id.ResultAccumlatedAmount);

        calculate.setOnClickListener(this);
        reset.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == calculate){
            CalculateCompoundInterest();
        }
        else if(v == reset){
            principalAmount.getText().clear();
            interestRate.getText().clear();
            termInYears.getText().clear();
            noInterestPayments.getText().clear();
            resultCompoundInterest.setText(null);
            resultAccumlatedAmount.setText(null);
        }
        else if(v == back){
            Intent ma = new Intent(this, MainActivity.class);
            startActivity(ma);
        }

    }

    private void CalculateCompoundInterest() {

        int p = Integer.parseInt(principalAmount.getText().toString());
        Float r  = Float.parseFloat(interestRate.getText().toString())/100;
        int t = Integer.parseInt(termInYears.getText().toString());
        int n = Integer.parseInt(noInterestPayments.getText().toString());
        Double totalPayment = p * (Math.pow((1+(r/n)),(n * t)));
        Double compoundInterest = totalPayment - p;
        resultCompoundInterest.setText(Double.toString(compoundInterest));
        resultAccumlatedAmount.setText(Double.toString(totalPayment));
    }

}
