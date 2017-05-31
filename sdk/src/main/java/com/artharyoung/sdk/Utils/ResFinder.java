package com.artharyoung.sdk.Utils;

import android.content.Context;

/**
 * Created by arthar on 2017/5/15.
 */

public class ResFinder {

    public static int getId(Context context, String defType, String name){

        int id=0;

        try {

            id = context.getResources().getIdentifier(name, defType, context.getPackageName());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return id;
    }
}
