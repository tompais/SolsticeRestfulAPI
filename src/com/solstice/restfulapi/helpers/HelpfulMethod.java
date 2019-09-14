package com.solstice.restfulapi.helpers;

public class HelpfulMethod {
    public static boolean IsStringNullOrEmpty(String string) {
        return string == null || string.trim().equals("") || string.trim().length() == 0;
    }
}
