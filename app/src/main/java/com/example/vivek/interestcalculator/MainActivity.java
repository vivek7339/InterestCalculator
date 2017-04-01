package com.example.vivek.interestcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button simpleInterest;
    private Button compoundInterest;
    private Button emiCalculator;
    private  Toolbar myToolbar;


    static  final  String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myToolbar = (Toolbar) findViewById(R.id.MainActivityToolbar);
        myToolbar.setTitle("Interest Calculator");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.inflateMenu(R.menu.mainmenu);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuAbout:
                        Log.v(LOG_TAG,"About Activity Started");
                        Intent si = new Intent(MainActivity.this, About.class);
                        startActivity(si);
                        return true;
                    case R.id.menuContactUs:
                        Log.v(LOG_TAG,"Contact Activity Started");
                        Intent cu = new Intent(MainActivity.this, ContactUs.class);
                        startActivity(cu);
                        return true;
                }
                return false;
            }
        });


        simpleInterest = (Button) findViewById(R.id.SimpleInterest);
        compoundInterest = (Button) findViewById(R.id.CompoundInterest);
        emiCalculator = (Button) findViewById(R.id.EMICalculator);


        simpleInterest.setOnClickListener(this);
        compoundInterest.setOnClickListener(this);
        emiCalculator.setOnClickListener(this);



        Log.v(LOG_TAG,"Activity Created");
    }




    @Override
    public void onClick(View v) {
        if(v == simpleInterest){
            Log.v(LOG_TAG,"SIC Activity Started");
            Intent si = new Intent(this, SimpleInterestCalculatorActivity.class);
            startActivity(si);
        }
        else if(v == compoundInterest){
            Log.v(LOG_TAG,"CIC Activity Started");
            Intent ci = new Intent(this, CompoundIntrestCalcualtorActivity.class);
            startActivity(ci);
        }
        else if(v == emiCalculator){
            Log.v(LOG_TAG,"EMIC Activity Started");
            Intent ec = new Intent(this, EMICalcualtorActivity.class);
            startActivity(ec);
        }
    }

}
