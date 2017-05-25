package com.artharyoung.sdk.Login;

import org.json.JSONObject;

/**
 * Created by arthar on 2017/5/25.
 */

public interface OnLoginListener {
    void onSuccess(JSONObject json);
    void onFailure(JSONObject json);
}
