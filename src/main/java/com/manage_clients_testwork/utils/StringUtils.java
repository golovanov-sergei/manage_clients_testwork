package com.manage_clients_testwork.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isEmpty(String string){
        return string.length()==0;
    }
    public static boolean emailNotValid(String email){
//        Regular Expression by RFC 5322 for Email Validation
        String regEx="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
    public static boolean phoneNotValid(String phone){
        String regEx = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phone);
        return !matcher.matches();
    }

}
