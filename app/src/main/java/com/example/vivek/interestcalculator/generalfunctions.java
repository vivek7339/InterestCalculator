package com.example.vivek.interestcalculator;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import static android.support.v4.content.ContextCompat.startActivity;


/**
 * Created by vivek on 3/31/2017.
 */

public class generalfunctions {

    private  Toolbar myToolbar;

    public void hidekeyboard(Activity activity){

        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }

    }

}
