package com.artharyoung.sdk.Pay;

import org.json.JSONObject;

/**
 * Created by arthar on 2017/5/25.
 */

public interface OnPayListener {
    void onSuccess(JSONObject json);
    void onFailure(JSONObject json);
    void cancel(JSONObject json);
}
