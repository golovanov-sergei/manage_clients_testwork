package com.manage_clients_testwork.utils;

public class StringUtils {
    public static boolean isEmpty(String string){
        return string.length()==0;
    }
    public static boolean emailNotValid(String password){
        String strRegEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$"; //сложность пароля надо бы вынести в настройки
        return !password.matches(strRegEx);
    }

}
