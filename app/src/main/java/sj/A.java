package sj;

import android.app.Application;
import com.game.ad.Gga;
import com.game.util.SharePreeHelp;


public class A extends Application {

    private static A application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
//        FirebaseApp.initializeApp(this);
        initFirebase();
        initAppsFlyer();
//        FacebookSdk.setAutoLogAppEventsEnabled(true);
//        AppEventsLogger.activateApp(this);
//        AppsFlyerLib.getInstance().setDebugLog(true);
        SharePreeHelp.instance().init(this);
        Gga.getInstance().initContext(null);
    }

    private void initFirebase() {
        //Firebase 获取token
//        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
//            if (!task.isSuccessful()) {
//                Log.i("TAG", "Fetching FCM FirebaseMessaging token failed:" + task.getException());
//                return;
//            }
//            Log.i("TAG", "Fetching FCM FirebaseMessaging token:" + task.getResult());
//            // Get new FCM registration token
//            String token = task.getResult();
//            SharePreferenceHelp.instance().pushString("fcmToken", token);
//        });
    }

    private void initAppsFlyer() {
//        AppsFlyerLib.getInstance().init(F.TEST_AF_KEY, new AppsFlyerConversionListener() {
//            @Override
//            public void onConversionDataSuccess(Map<String, Object> map) {
//                String status = (String) map.get("af_status");
//                Log.i("initAppsFlyer", "onConversionDataSuccess" + status);
//                if (status == "Non-organic") {
//                    EventBus.getDefault().post("update");
//                }
//                SharePreferenceHelp.instance().pushString("installReferrer", status);
//            }
//
//            @Override
//            public void onConversionDataFail(String s) {
//                Log.i("initAppsFlyer", "onConversionDataFail" + s);
//                Bundle params = new Bundle();
//                params.putString("msg", s);
//                LogHelp.instance().fireBaseLog("non_organic_check_fail", s, 400);
//            }
//
//            @Override
//            public void onAppOpenAttribution(Map<String, String> map) {
//                Log.i("initAppsFlyer", "onAppOpenAttribution" + map.toString());
//            }
//
//            @Override
//            public void onAttributionFailure(String s) {
//                Log.i("initAppsFlyer", "onAttributionFailure:" + s);
//            }
//        }, this);
//        AppsFlyerLib.getInstance().start(this);
//        LogHelp.instance().fireBaseLog("non_organic_check", null, 200);
    }

    public static A getInstance() {
        return application;
    }

}
