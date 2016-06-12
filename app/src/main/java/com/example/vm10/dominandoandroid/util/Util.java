package com.example.vm10.dominandoandroid.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.vm10.dominandoandroid.R;

public final class Util {

    public static void showDialog(Context context, String title, String content) {
        new MaterialDialog.Builder(context)
            .title(title)
            .content(content)
            .positiveText(R.string.ok)
            .show();
    }

    public static int convertDIPToPixels(Context context, int dip) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics);
    }
}
