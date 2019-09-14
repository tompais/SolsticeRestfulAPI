package com.solstice.restfulapi.helpers;

public class HelpfulMethod {
    public static boolean IsStringNullOrEmpty(String string) {
        return string == null || string.equals("") || string.length() == 0;
    }
}
