package com.artharyoung.sdk.Login.LogIn;

/**
 * Created by arthar on 2017/5/25.
 */

public interface OnLoginListener {
    void onSuccess(String statue,String token);
    void onFailure(String statue,String msg);
}
