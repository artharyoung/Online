package com.artharyoung.sdk.Utils;

import android.app.Activity;

import com.artharyoung.sdk.Login.LogIn.OnLoginListener;
import com.artharyoung.sdk.Pay.OnPayListener;

import org.json.JSONObject;

/**
 * Created by arthar on 2017/5/25.
 */

public interface GameServer {
    void login(Activity activity, OnLoginListener onLoginListener);
    void pay(String payInfo,OnPayListener onPayListener);
    void upLoadInfo(JSONObject json);
    void exitApp();
}
