package com.example.vivek.interestcalculator;


import android.app.Activity;
import android.content.Context;;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by vivek on 3/31/2017.
 */

public class generalfunctions {


    public void hidekeyboard(Activity activity){

        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }

    }
}
