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

public class EMICalcualtorActivity extends AppCompatActivity implements OnClickListener{

    private EditText principalAmount, interestRate, termInYears;
    private Button calculate, reset, back;
    private TextView resultEMI, resultTotalInterest, printError;
    private Toolbar myToolbar;

    static  final  String LOG_TAG = "EMICActivity";
    generalfunctions hk = new generalfunctions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emicalcualtor);

        myToolbar = (Toolbar) findViewById(R.id.EMICToolbar);
        myToolbar.setTitle("EMI Calculator");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.inflateMenu(R.menu.mainmenu);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuAbout:
                        Log.v(LOG_TAG,"About Activity Started");
                        Intent si = new Intent(EMICalcualtorActivity.this, About.class);
                        startActivity(si);
                        return true;
                    case R.id.menuContactUs:
                        Log.v(LOG_TAG,"Contact Activity Started");
                        Intent cu = new Intent(EMICalcualtorActivity.this, ContactUs.class);
                        startActivity(cu);
                        return true;
                }
                return false;
            }
        });

        generalfunctions hk = new generalfunctions();

        principalAmount = (EditText) findViewById(R.id.PrincipalAmountEMI);
        interestRate = (EditText) findViewById(R.id.InterestRateEMI);
        termInYears = (EditText) findViewById(R.id.TermInYearEMI    );
        calculate = (Button) findViewById(R.id.CalculateEMI);
        reset = (Button) findViewById(R.id.ResetEMI);
        back = (Button) findViewById(R.id.BackEMI);
        resultEMI = (TextView) findViewById(R.id.EMIResult);
        resultTotalInterest = (TextView) findViewById(R.id.TotalInterestResult);
        printError = (TextView) findViewById(R.id.ErrorEMI);

        calculate.setOnClickListener(this);
        reset.setOnClickListener(this);
        back.setOnClickListener(this);
        Log.v(LOG_TAG,"Activity Started");
    }

    @Override
    public void onClick(View v) {
        if(v == calculate){
            CalculateEMI();
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
        resultEMI.setText(null);
        resultTotalInterest.setText(null);
        printError.setText(null);
    }

    private void CalculateEMI() {
        if(principalAmount.getText().toString().isEmpty() || interestRate.getText().toString().isEmpty() ||  termInYears.getText().toString().isEmpty()){
            reset();
            printError.setText("Enter all Value");
            hk.hidekeyboard(this);
        }
        else{
            Log.v(LOG_TAG,"EMI Calculated");
            hk.hidekeyboard(this);
            DecimalFormat df = new DecimalFormat("0.00");
            int p = Integer.parseInt(principalAmount.getText().toString());
            int n = 12 * Integer.parseInt(termInYears.getText().toString());
            Float i  = Float.parseFloat(interestRate.getText().toString()) / 1200;
            double EMI = (p * i) * (Math.pow(1 + i , n)) /(Math.pow(1 + i , n) - 1);
            double totalInterest = (EMI * n) - p;
            resultEMI.setText(df.format(EMI));
            resultTotalInterest.setText(df.format(totalInterest));
            printError.setText(null);
        }
    }
}
