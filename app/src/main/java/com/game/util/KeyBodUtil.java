package com.game.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;

public class KeyBodUtil {

    private Activity activity;
    private View view;


    private ViewTreeObserver viewViewTreeObserver;

    public KeyBodUtil(Activity activity, View view) {
        this.activity = activity;
        this.view = view;
    }


    public void onCreate() {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        viewViewTreeObserver = view.getViewTreeObserver();
        viewViewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {

        @Override
        public void onGlobalLayout() {
            if (view != null) {
                Rect visibleRect = new Rect();
                view.getWindowVisibleDisplayFrame(visibleRect);
                if (visibleRect.height() < view.getHeight() * 0.75f) {
                    int paddingLeft = visibleRect.left;
                    int paddingTop = visibleRect.top;
                    int paddingRight = view.getWidth() - visibleRect.right;
                    int paddingBottom = view.getHeight() - visibleRect.bottom;
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                } else {
                    showWindow(activity.getWindow());
                    view.setPadding(0, 0, 0, 0);
                }
            }
        }
    };

    private void showWindow(Window window) {
        View decorView = window.getDecorView();
        int uiOptions =
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }


    public void onDestroy() {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        if (viewViewTreeObserver.isAlive() == true) {
            viewViewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

}
