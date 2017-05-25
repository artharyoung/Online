package com.artharyoung.sdk;

import android.app.Activity;

/**
 * Created by arthar on 2017/5/25.
 */

public interface ActivityLifecycle {
    void onActivityCreated(Activity activity);
    void onActivityStarted(Activity activity);
    void onActivityResumed(Activity activity);
    void onActivityPaused(Activity activity);
    void onActivityStopped(Activity activity);
    void onActivityDestroyed(Activity activity);
}
