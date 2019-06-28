package com.example.myproject.common;

import org.springframework.util.StringUtils;

public class DataUtil {

    public static  boolean isNumber(String string) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        return string.chars().allMatch(Character::isDigit);
    }
}
