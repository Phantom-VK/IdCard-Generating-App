package com.app.idCard.java;

import android.content.Context;
import android.widget.Toast;

public class AppUtils{

    public void makeToast(Context context){
        Toast.makeText(context , "Kotlin button pressed", Toast.LENGTH_LONG).show();
    }
}