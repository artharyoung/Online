package com.artharyoung.sdk;

import com.artharyoung.sdk.Login.OnLoginListener;
import com.artharyoung.sdk.Pay.OnPayListener;

import org.json.JSONObject;

/**
 * Created by arthar on 2017/5/25.
 */

public interface GameServer {
    void login(OnLoginListener onLoginListener);
    void pay(String payInfo,OnPayListener onPayListener);
    void upLoadInfo(JSONObject json);
    void exitApp();
}
