package com.emall.utils;

public class StringUtil {
    public static String stringArrayToString(String[] s){
        StringBuffer sb = new StringBuffer();
        sb.append(s[0]);
        for(int i = 1; i < s.length; i++){
            sb.append(","+s[i]);
        }
        return sb.toString();
    }
    public static String[] stringToStringArray(String s){
        return s.split(",");
    }
}
