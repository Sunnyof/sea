package com.game.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.game.util.JSONUtil;
import com.game.util.SharePreferenceHelp;


import java.util.HashMap;

public class LocalFirebaseMessagingService extends Service {
    private HashMap fcmMap = new HashMap<String, Object>();

//    public void onMessageReceived(RemoteMessage message) {
//        super.onMessageReceived(message);
//        if (message.getData() != null) {
//            fcmMap.putAll(message.getData());
//        }
//        fcmMap.put("from", message.getFrom());
//        fcmMap.put("google.collapseKey:", message.getCollapseKey());
//        fcmMap.put("google.originalPriority:", (message.getOriginalPriority() == RemoteMessage.PRIORITY_HIGH) ? "high" : "normal");
//        fcmMap.put("messageId:", message.getMessageId());
//        fcmMap.put("priority:", (message.getPriority() == RemoteMessage.PRIORITY_HIGH) ? "high" : "normal");
//        SharePreferenceHelp.instance().pushString("fcmData", JSONUtil.map2Json(fcmMap));
//    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
