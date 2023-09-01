package com.game.util;

import android.app.Activity;

import com.game.d.BaseViewModel;
import com.game.d.RequestHelp;
import sj.F;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;

public class DialogUtil {

    private static String[] ERROR_1 = {"Jaringan  terputus, coba sambungkan kembali?", "Menghubungkan kembali"};
    private static String[] ERROR_2 = {"Mạng bị ngắt kết nối. Bạn có muốn cập nhật lại không?", "kết nối lại"};
    private static String[] ERROR_3 = {"Desconectado, tente atualizar de novo?", "Reconecte"};
    private static String[] ERROR_4 = {"Disconnected, try update again?", "Reconnect"};


    private static String[] CHOICE_1 = {"Kamera", "Foto", "Folder"};
    private static String[] CHOICE_2 = {"Máy ảnh", "Hình chụp", "Tài liệu"};
    private static String[] CHOICE_3 = {"Câmera", "Foto", "Arquivo"};
    private static String[] CHOICE_4 = {"Camera", "Photo", "File"};
    private static  BasePopupView popupView;

    public static void showErrorDialog(Activity activity, BaseViewModel baseViewModel) {
        if(null == popupView)
         popupView = new XPopup.Builder(activity)
                .dismissOnTouchOutside(false)
                .isDestroyOnDismiss(false)
                .isTouchThrough(false)
                .dismissOnBackPressed(false)
                .hasBlurBg(true)
                .maxWidth(800)
                .isClickThrough(false)
                .popupAnimation(PopupAnimation.NoAnimation)
                .asConfirm("", netTip()[0],
                        "",netTip()[1],
                        () -> RequestHelp.reconnect(true, baseViewModel), null, true);
        if(popupView.isDismiss()) {
            popupView.show();
        }
    }


    public static int getPlatform() {
        int platform = F.INT_CHANNEL_ID;
        String channelId = SharePreferenceHelp.instance().popString(F.CHANNEL_ID);
        if (!channelId.isEmpty()) {
            try {
                platform = Integer.parseInt(channelId);
            } catch (Exception e) {
                platform = F.INT_CHANNEL_ID;
            }
        }
        return platform;
    }


    //网络错误弹框
    public static String[] netTip() {
        switch (getPlatform()) {
            case 28:
            case 29:
                return ERROR_1;
            case 30:
            case 33:
            case 330000:
            case 38:
                return ERROR_2;
            case 32:
                return ERROR_3;
        }
        return ERROR_4;
    }

    //客服弹框选项
    public static String[] choice() {
        switch (getPlatform()) {
            case 28:
            case 29:
                return CHOICE_1;
            case 30:
            case 33:
            case 330000:
            case 38:
                return CHOICE_2;
            case 32:
                return CHOICE_3;
        }
        return CHOICE_4;
    }
}
