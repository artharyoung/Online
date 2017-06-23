package com.artharyoung.sdk.Login;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    private static final String TAG = "BaseLoginView";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE,ResFinder.getId(getActivity(),"style","online_sdk_login_dialog"));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Dialog dialog = getDialog();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                //在这里适配屏幕的大小显示
//              dialog.getWindow().setBackgroundDrawableResource(ResFinder.getId(getActivity(),"drawable","online_sdk_solid"));

            }
        });
        dialog.setCanceledOnTouchOutside(false);

        Window window = dialog.getWindow();
        if(window != null) {
            window.setWindowAnimations(ResFinder.getId(getActivity(), "style", "online_sdk_login_anim"));
            window.setGravity(Gravity.CENTER);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
