package com.game.ad;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import sj.A;
import sj.F;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import com.deepsea.charge.BuildConfig;


public class Gga {
    private static String TAG = Gga.class.getSimpleName();
    private static Gga gameGoogleAd = new Gga();

    private InterstitialAd mInterstitialAd;

    public static Gga getInstance() {
        return gameGoogleAd;
    }

    private Activity mContext;

    public void initContext(Activity context) {
        this.mContext = context;
        initAd();
    }

    /**
     * 广告全屏回调
     */
    private FullScreenContentCallback mCallBack = new FullScreenContentCallback() {
        @Override
        public void onAdClicked() {
            super.onAdClicked();
            Log.i(TAG, "onAdClicked");
        }

        @Override
        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            Log.i(TAG, "onAdDismissedFullScreenContent");
            mInterstitialAd = null;
            initAd();
        }

        @Override
        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            Log.i(TAG, "onAdFailedToShowFullScreenContent");
        }

        @Override
        public void onAdImpression() {
            super.onAdImpression();
            Log.i(TAG, "onAdImpression");
        }

        @Override
        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            Log.i(TAG, "onAdShowedFullScreenContent");
        }
    };

    /**
     * 初始化Google广告
     */
    private void initAd() {
        InterstitialAd.load(A.getInstance(), getAdUnitId(), new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.i(TAG, "onAdFailedToLoad" + loadAdError.getMessage());
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);
                Log.i(TAG, "onAdLoaded" + interstitialAd.getAdUnitId());
                mInterstitialAd = interstitialAd;
                interstitialAd.setFullScreenContentCallback(mCallBack);
            }
        });
    }

    /**
     * 展示广告
     *
     */
    public void showAd() {
        mContext.runOnUiThread(() -> {
            if (null != mInterstitialAd) {
                mInterstitialAd.show(mContext);
            }
        });
    }

    /**
     * 获取广告ID
     *
     * @return
     */
    private String getAdUnitId() {
        if (BuildConfig.DEBUG) {
            return F.DEBUG_AD_UNIT_ID;
        }
        return F.AD_UNIT_ID;
    }
}
