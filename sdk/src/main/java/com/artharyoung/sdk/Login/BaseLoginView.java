package com.artharyoung.sdk.Login;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.artharyoung.sdk.Utils.ResFinder;

/**
 * Created by arthar on 2017/5/31.
 */

public class BaseLoginView extends DialogFragment {
//    private Context mContext = null;
//
//    public BaseLoginView(@NonNull Context context) {
//        super(context,ResFinder.getId(context,"style","online_sdk_login_dialog"));
////        super(context);
//        mContext = context;
//    }
//
//    public BaseLoginView(@NonNull Context context, @StyleRes int themeResId) {
//        super(context, themeResId);
//        mContext = context;
//    }
//
//    protected BaseLoginView(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
//        super(context, cancelable, cancelListener);
//        mContext = context;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setCanceledOnTouchOutside(false);
//
//        Window window = getWindow();
//        window.setWindowAnimations(ResFinder.getId(mContext,"style","online_sdk_login_anim"));
//    }
//
//    protected final Context getBaseContext(){
//        return mContext;
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Dialog dialog = getDialog();
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = dialog.getWindow();
        window.getAttributes().windowAnimations = ResFinder.getId(getActivity(),"style","online_sdk_login_anim");
        window.setGravity(Gravity.CENTER);
        setStyle(DialogFragment.STYLE_NO_TITLE,ResFinder.getId(getActivity(),"style","online_sdk_login_dialog"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
