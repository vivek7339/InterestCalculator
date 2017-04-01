package com.example.vivek.interestcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class ContactUs extends AppCompatActivity {

    private Toolbar myToolbar;
    static  final  String LOG_TAG = "ContactUSActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        myToolbar = (Toolbar) findViewById(R.id.ContactUSToolbar);
        myToolbar.setTitle("Contact");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.inflateMenu(R.menu.mainmenu);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuAbout:
                        Log.v(LOG_TAG,"About Activity Started");
                        Intent si = new Intent(ContactUs.this, About.class);
                        startActivity(si);
                        return true;
                    case R.id.menuContactUs:
                        Log.v(LOG_TAG,"Contact Activity Started");
                        Intent cu = new Intent(ContactUs.this, ContactUs.class);
                        startActivity(cu);
                        return true;
                }
                return false;
            }
        });

    }
}
