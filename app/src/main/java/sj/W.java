package sj;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 英文字符位移编解码
 */
public class W {

    public static String encode(String text,String key){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<text.length();i++){
            char c = text.charAt(i);
            int index = key.indexOf(c);
            if (index!=-1){
                index++;
                if (index>=key.length()){
                    index = 0;
                }
                stringBuilder.append(key.charAt(index));
            }else{
                stringBuilder.append(c);
            }

        }
        return stringBuilder.toString();
    }

    public static String decode(String text,String key){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<text.length();i++){
            char c = text.charAt(i);
            int index = key.indexOf(c);
            if (index!=-1){
                index--;
                if (index<0){
                    index = key.length()-1;
                }
                stringBuilder.append(key.charAt(index));
            }else{
                stringBuilder.append(c);
            }

        }
        return stringBuilder.toString();
    }

    public static String genKey(){
        String key = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<String> keyList = new ArrayList<>();
        for (int i=0;i<key.length();i++){
            keyList.add(String.valueOf(key.charAt(i)));
        }
        Collections.shuffle(keyList);
        StringBuilder result = new StringBuilder();
        for (String i:keyList){
            result.append(i);
        }
        return result.toString();
    }

}
