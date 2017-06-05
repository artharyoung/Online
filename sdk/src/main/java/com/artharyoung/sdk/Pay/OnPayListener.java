package com.artharyoung.sdk.Pay;

/**
 * Created by arthar on 2017/5/25.
 */

public interface OnPayListener {
    void onSuccess(String statue,String msg);
    void onFailure(String statue,String msg);
    void cancel(String statue,String msg);
}
