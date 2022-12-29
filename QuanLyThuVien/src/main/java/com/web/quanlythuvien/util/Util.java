package com.web.quanlythuvien.util;

public class Util {

    public static boolean isNullOrEmpty(String str){
        if (str != null && !str.equals(""))
            return false;
        return true;
    }

}
