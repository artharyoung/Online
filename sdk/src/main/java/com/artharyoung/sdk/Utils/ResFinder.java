package com.artharyoung.sdk.Utils;

import android.content.Context;
import android.util.Log;

/**
 * Created by arthar on 2017/5/15.
 */

public class ResFinder {

    private static final String TAG = "ResFinder";
    public static int getId(Context context, String defType, String name){

        int id=0;

        try {

            id = context.getResources().getIdentifier(name, defType, context.getPackageName());

        } catch (Exception e) {
            Log.d(TAG, "========getId======: " + "type:" + defType +"|name:" + name);
        }

        return id;
    }
}
