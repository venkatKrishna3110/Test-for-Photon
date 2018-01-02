package com.android.photon.test.testphoton;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class GlobalVariables {

    public static ArrayList<HashMap<String, String>> variablesArray = new ArrayList<>();

    public static void showAlert(Context c, String title, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setNeutralButton("OK", null);
        dialog.create().show();
    }

    public static void showAlertAndGoBack(final Context c, String title,
                                          String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setCancelable(false);
        dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((Activity) c).finish();
            }
        });
        try {
            dialog.create().show();
        } catch (Exception e) {

        }
    }

    public static void savePreferences(Context sCntxt, String key,
                                       String value) {
        SharedPreferences sharedPreferences = sCntxt.getSharedPreferences(
                "VENKAT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String loadPreferences(Context lCntxt, String key) {
        SharedPreferences sharedPreferences = lCntxt.getSharedPreferences(
                "VENKAT", Context.MODE_PRIVATE);
        String val = "";
        try {
            val = sharedPreferences.getString(key, "");
        } catch (Exception e) {
            val = "";
        }
        return val;
    }

    public static boolean iO() {
        try {
            Process p1 = Runtime.getRuntime().exec("ping -c 1    www.google.com");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal == 0);
            if (reachable)
                return reachable;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialogboxprogress);
        return dialog;
    }

    public static String getDate() {
        Calendar c = Calendar.getInstance();
        return new SimpleDateFormat("dd MMM, yyyy").format(c.getTime());
    }

    public static String getTime() {
        Calendar c = Calendar.getInstance();
        return new SimpleDateFormat("hh:mm a").format(c.getTime());
    }

    public static void hideKeyboard(Context cntxt, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) cntxt.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showKeyboard(Context cntxt, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) cntxt.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                    0);
        }
    }
}
